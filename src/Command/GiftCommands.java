package Command;

import Sweets.*;

import java.util.*;

public class GiftCommands {

    public void printSweetsInfo(List<Sweets> sweetsList) {
        for (Sweets sweets : sweetsList) {
            System.out.println(sweets.toString());
        }
    }

    public void addCandyToGift(List<Sweets> sweetsList, List<Sweets> gift) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть цукерки (exit для завершення) ");
        for (int i = 0; i < sweetsList.size(); i++) {
            System.out.println((i + 1) + ". " + sweetsList.get(i).getName());
        }
        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex <= sweetsList.size()) {
                    Sweets selectedCandy = sweetsList.get(candyIndex);
                    gift.add(selectedCandy);
                    System.out.println("Цукерка " + "'" + selectedCandy.getName() + "'" + " додана до подарунку");
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректне введеня. Спробуйте ще раз");
            }
        }
    }

    public void removeCandyFromGift(List<Sweets> gift) {
        Scanner scanner = new Scanner(System.in);

        compositionOfTheGift(gift);
        System.out.println("Введіть номер цукерки, яку хочете вилучити, або 'exit' для виходу:");

        while (true) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int candyIndex = Integer.parseInt(input) - 1;
                if (candyIndex >= 0 && candyIndex < gift.size()) {
                    Sweets selectedCandy = gift.remove(candyIndex);
                    System.out.println("Цукерка " + selectedCandy.getName() + " вилучена із вашого подарунку");
                    compositionOfTheGift(gift);
                } else {
                    System.out.println("Неправильний номер. Спробуйте ще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Спробуйте ще раз.");
            }
        }

    }

    public void calculateGiftWeight(List<Sweets> gift) {

        double totalWeight = 0.0;

        for (Sweets sweets : gift) {
            totalWeight += sweets.getWeight();
        }
        System.out.println("Загальна вага подарунка = " + totalWeight + " грам");
    }

    public void sortCandies(List<Sweets> gift) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть тип сортування:");
        System.out.println("1. за назвою цукерки");
        System.out.println("2. за вмістом цукру");
        System.out.println("3. за вагою");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> sortByName(gift);
            case 2 -> sortBySugarContent(gift);
            case 3 -> sortByWeight(gift);
            default -> System.out.println("Такого пункту немає");
        }
    }

    public void findCandyBySugarContent(List<Sweets> gift) {
        List<Sweets> candyBySugar = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діапазон цукру (у відсотках ):");
        System.out.print("Від: ");
        double choice1 = scanner.nextDouble();
        System.out.print("До: ");
        double choice2 = scanner.nextDouble();

        for (Sweets candy : gift) {
            if (candy.getSugarContent() >= choice1 && candy.getSugarContent() <= choice2) {
                candyBySugar.add(candy);
            }
        }

        if (candyBySugar.isEmpty()) {
            System.out.println("Таких цукерок немає");
        } else {
            System.out.println("Цукерки за вмістом цукру в діапазоні [" + choice1 + ";" + choice2 + "]:");
            for (Sweets candy : candyBySugar) {
                System.out.println(candy.getName() + " - Вміст цукру: " + candy.getSugarContent() + "%");
            }
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
        gift.sort(new Comparator<Sweets>() {
            @Override
            public int compare(Sweets o1, Sweets o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
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
}