package Gift;

import Command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GiftRunner {
    public static void main(String[] args) {
        GiftCommands commands = new GiftCommands();

        User user = new User(
                new addCandyToGiftCommand(commands),
                new calculateGiftWeightCommand(commands),
                new compositionOfTheGiftCommand(commands),
                new findCandyBySugarContentCommand(commands),
                new printSweetsInfoCommand(commands),
                new removeCandyFromGiftCommand(commands),
                new sortCandiesCommand(commands)
        );

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
                switch (choice) {
                    case "add" -> user.addCandyToGiftRecord();
                    case "weight" -> user.calculateGiftWeightRecord();
                    case "contain" -> user.compositionOfTheGiftRecord();
                    case "find" -> user.findCandyBySugarContentRecord();
                    case "sort" -> user.sortCandiesRecord();
                    case "remove" -> user.removeCandyFromGiftRecord();
                    case "info" -> user.printSweetsInfoRecord();
                    case "exit" -> {
                        System.out.println("Дякуємо за використання програми!");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Невірна команда. Введіть 'help' для виведення списку команд.");
            }
        }
    }
}
