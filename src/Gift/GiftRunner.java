package Gift;

import Command.*;
import Sweets.Sweets;

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
        commandMap.put("add", new addCandyToGiftCommand(commands, sweetsList, gift));
        commandMap.put("weight", new calculateGiftWeightCommand(commands, gift));
        commandMap.put("contain", new compositionOfTheGiftCommand(commands, gift));
        commandMap.put("find", new findCandyBySugarContentCommand(commands, gift));
        commandMap.put("info", new printSweetsInfoCommand(commands, sweetsList));
        commandMap.put("remove", new removeCandyFromGiftCommand(commands, gift));
        commandMap.put("sort", new sortCandiesCommand(commands, gift));

        User user = new User(commandMap);

        Map<String, String> menu = new HashMap<>();
        menu.put("add", "Додати цукерку до подарунка");
        menu.put("weight", "Вага всього подарунка");
        menu.put("contain", "Вміст подарунка");
        menu.put("find", "Знайти цукерку за певним вмістом цукру");
        menu.put("info", "Інформація про всі солодощі");
        menu.put("remove", "Вилучити цукерку з подарунка");
        menu.put("sort", "Відсортувати цукерки");
        menu.put("exit", "Вихід");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть команду (або 'help' для виведення списку команд): ");
            String choice = scanner.nextLine();
            if (choice.equals("help")) {
                System.out.println("Доступні команди:");
                for (Map.Entry<String, String> entry : menu.entrySet()) {
                    System.out.println(entry.getKey() + " >> " + entry.getValue());
                }

            } else if (menu.containsKey(choice)) {
                String commandDescription = menu.get(choice);
                System.out.println("Ви обрали команду: " + commandDescription);
                user.executeCommand(choice);

                if (choice.equals("exit")) {
                    System.out.println("Дякуємо за використання програми!");
                    System.exit(0);
                }
            } else {
                System.out.println("Неправильна команда. Введіть 'help' для виведення списку команд.");
            }
        }
    }
}
