package gift;

import command.*;
import sweets.Sweets;
import user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GiftRunner {
    public static void main(String[] args) {
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
            if (choice.equals("help")) {
                System.out.println("Доступні команди:");
                for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
                    System.out.println(entry.getKey() + " >> " + entry.getValue().getDescription());
                }
            } else if (choice.equals("exit")) {
                System.out.println("Дякуємо за використання програми!");
                System.exit(0);
            } else if (commandMap.containsKey(choice)) {
                String commandDescription = commandMap.get(choice).getDescription();
                System.out.println("Ви обрали команду: " + commandDescription);
                user.executeCommand(choice);
            } else {
                System.out.println("Неправильна команда. Введіть 'help' для виведення списку команд.");
            }
        }
    }
}
