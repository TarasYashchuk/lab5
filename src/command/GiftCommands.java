package command;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import gift.GiftRunner;
import sweets.*;

import java.util.*;

import static gift.GiftRunner.sendCriticalErrorEmail;
public class GiftCommands{

    public void printSweetsInfo(List<Sweets> sweetsList) {
        for (Sweets sweets : sweetsList) {
            System.out.println(sweets.toString());
        }
    }
    public void addCandyToGift(List<Sweets> sweetsList, List<Sweets> gift) throws Exception {
        Logger logger = makeLog();

        logger.info("Команда 'addCandyToGift' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть цукерки (exit для завершення) ");

        for (int i = 0; i < sweetsList.size(); i++) {
            System.out.println((i + 1) + ". " + sweetsList.get(i).getName());
        }
        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Команда 'addCandyToGift' закінчила роботу.");
                break;
            }

            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex < sweetsList.size()) {
                    Sweets selectedCandy = sweetsList.get(candyIndex);
                    gift.add(selectedCandy);
                    System.out.println("Цукерка " + "'" + selectedCandy.getName() + "'" + " додана до подарунку");

                    logger.info("Додана цукерка до подарунку: " + selectedCandy.getName());
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз");

                    logger.warning("Спроба додати цукерку за неправильним номером: " + input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректне введення. Спробуйте ще раз");
                logger.warning("Помилка при спробі додати цукерку: " + e.getMessage());
                sendCriticalErrorEmail(e);
            }
        }
    }
    public void removeCandyFromGift(List<Sweets> gift) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Logger logger = makeLog();
        logger.info("Команда 'removeCandyFromGift' почала роботу.");
        compositionOfTheGift(gift);
        System.out.println("Введіть номер цукерки, яку хочете вилучити, або 'exit' для виходу:");

        while (true) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                logger.info("Команда 'removeCandyFromGift' закінчила роботу.");
                break;
            }

            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex < gift.size()) {
                    Sweets selectedCandy = gift.remove(candyIndex);
                    System.out.println("Цукерка " + selectedCandy.getName() + " вилучена із вашого подарунку");
                    compositionOfTheGift(gift);
                    logger.info("Цукерка " + selectedCandy.getName() + " вилучена із подарунку");
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз.");
                    logger.warning("Неправильний номер: " + input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Спробуйте ще раз");
                logger.warning("Неправильний ввід: " + input);
                sendCriticalErrorEmail(e);
            }
        }
    }
    public void calculateGiftWeight(List<Sweets> gift) throws Exception {
        Logger logger = makeLog();
        logger.info("Команда 'calculateGiftWeight' почала роботу.");
        double totalWeight = 0.0;
        try {
            for (Sweets sweets : gift) {
                totalWeight += sweets.getWeight();
            }
            System.out.println("Загальна вага подарунка = " + totalWeight + " грам");

            logger.info("Загальна вага подарунка = " + totalWeight + " грам");
        } catch (Exception e) {
            System.out.println("Сталася помилка при обчисленні ваги подарунка: " + e.getMessage());
            logger.warning("Помилка при обчисленні ваги подарунка: " + e.getMessage());
            sendCriticalErrorEmail(e);
        }
        logger.info("Команда 'calculateGiftWeight' закінчила роботу.");
    }
    public void sortCandies(List<Sweets> gift) throws Exception {
        Logger logger = makeLog();
        logger.info("Команда 'sortCandies' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть тип сортування:");
        System.out.println("1. за назвою цукерки");
        System.out.println("2. за вмістом цукру");
        System.out.println("3. за вагою");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> sortByName(gift);
                case 2 -> sortBySugarContent(gift);
                case 3 -> sortByWeight(gift);
                default -> System.out.println("Такого пункту немає");
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильний ввід. Введіть числове значення.");
            logger.warning("Неправильний ввід при сортуванні цукерок: " + e.getMessage());
            sendCriticalErrorEmail(e);
        }
        logger.info("Команда 'sortCandies' закінчила роботу.");
    }
    public void findCandyBySugarContent(List<Sweets> gift) throws Exception {
        List<Sweets> candyBySugar = new ArrayList<>();
        Logger logger = makeLog();
        logger.info("Команда 'findCandyBySugarContent' почала роботу.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діапазон цукру (у відсотках):");

        try {
            System.out.print("Від: ");
            double choice1 = scanner.nextDouble();
            System.out.print("До: ");
            double choice2 = scanner.nextDouble();

            logger.info("Введено діапазон цукру: Від " + choice1 + " До " + choice2);

            for (Sweets candy : gift) {
                if (candy.getSugarContent() >= choice1 && candy.getSugarContent() <= choice2) {
                    candyBySugar.add(candy);
                }
            }

            if (candyBySugar.isEmpty()) {
                System.out.println("Таких цукерок немає");

                logger.info("Таких цукерок немає у діапазоні [" + choice1 + ";" + choice2 + "]");

                logger.info("Команда 'findCandyBySugarContent' закінчила роботу.");
            } else {
                System.out.println("Цукерки за вмістом цукру в діапазоні [" + choice1 + ";" + choice2 + "]:");
                for (Sweets candy : candyBySugar) {
                    System.out.println(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
                }

                logger.info("Знайдено цукерок у діапазоні [" + choice1 + ";" + choice2 + "]");
            }
        } catch (InputMismatchException e) {
            System.out.println("Невірний ввід. Введіть числове значення.");

            logger.warning("Невірний ввід при пошуку цукерок за вмістом цукру: " + e.getMessage());
        }
    }
    public void compositionOfTheGift(List<Sweets> gift) {
        System.out.println("Склад вашого подарунку:");
        for (int i = 0; i < gift.size(); i++) {
            System.out.println((i + 1) + ". " + gift.get(i).getName());
        }
    }
    public void sortBySugarContent(List<Sweets> gift) {
        gift.sort((candy1, candy2) -> Double.compare(candy1.getSugarContent(), candy2.getSugarContent()));
        System.out.println("Цукерки відсортовано за вмістом цукру:");
        for (Sweets candy : gift) {
            System.out.println(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
        }
    }
    public void sortByName(List<Sweets> gift) {
        gift.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Цукерки відсортовано за назвою:");
        for (Sweets candy : gift) {
            System.out.println(candy.getName());
        }
    }
    public void sortByWeight(List<Sweets> gift) {
        gift.sort((candy1, candy2) -> Double.compare(candy1.getWeight(), candy2.getWeight()));

        System.out.println("Цукерки відсортовано за вагою");
        for (Sweets candy : gift) {
            System.out.println(candy.getName() + " - Вага: " + candy.getWeight() + "грам");
        }
    }
    private static Logger makeLog() throws Exception {
        Logger logger = Logger.getLogger(GiftRunner.class.getName());
        FileHandler fileHandler;
        fileHandler = new FileHandler("giftCommands.log");
        try {
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logger;
    }
}

