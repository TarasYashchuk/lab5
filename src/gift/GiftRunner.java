package gift;

import command.*;
import mailsender.MailSender;
import sweets.Sweets;
import user.User;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class GiftRunner {
    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getLogger(GiftRunner.class.getName());
        FileHandler fileHandler;
        fileHandler = new FileHandler("giftRunner.log");
        try {
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Програма почала роботу.");

        GiftCommands commands = new GiftCommands();

        List<Sweets> sweetsList = Sweets.getSweetsList();
        List<Sweets> gift = Sweets.getGiftList();

        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("add", new AddCandyToGiftCommand(commands, sweetsList, gift));
        commandMap.put("weight", new CalculateGiftWeightCommand(commands, gift));
        commandMap.put("contain", new CompositionOfTheGiftCommand(commands, gift));
        commandMap.put("find", new FindCandyBySugarContentCommand(commands, gift));
        commandMap.put("info", new PrintSweetsInfoCommand(commands, sweetsList));
        commandMap.put("remove", new RemoveCandyFromGiftCommand(commands, gift));
        commandMap.put("sort", new SortCandiesCommand(commands, gift));

        User user = new User(commandMap);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть команду (або 'help' для виведення списку команд): ");
            String choice = scanner.nextLine();

            logger.info("Користувач ввів команду: " + choice);

            try{
                if (choice.equals("help")) {
                    System.out.println("Доступні команди:");
                    for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
                        System.out.println(entry.getKey() + " >> " + entry.getValue().getDescription());
                    }
                } else if (choice.equals("exit")) {
                    System.out.println("Дякую за використання програми!");
                    logger.info("Програма завершила роботу.");
                    fileHandler.close();
                    System.exit(0);
                } else if (commandMap.containsKey(choice)) {
                    String commandDescription = commandMap.get(choice).getDescription();
                    System.out.println("Ви обрали команду: " + commandDescription);
                    logger.info("Виконується обробка команди " + commandDescription);
                    user.executeCommand(choice);
                } else {
                    throw new IllegalArgumentException("Неправильна команда. Введіть 'help' для виведення списку команд.");
                }
            } catch (IllegalArgumentException e){
                logger.warning("Помилка: " + e.getMessage());
                e.printStackTrace();
                sendCriticalErrorEmail(e);
            }
        }
    }
    public static void sendCriticalErrorEmail(Exception e) {
        MailSender.sendMessage(e);
    }
}
