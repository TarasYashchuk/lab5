package command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sweets.Sweets;
import sweets.candies.caramel.CaramelCandy;
import sweets.other.cookies.ChocolateCookie;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiftCommandsTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintSweetsInfo() {
        List<Sweets> sweetsList = new ArrayList<>();
        sweetsList.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.printSweetsInfo(sweetsList);

        String expectedOutput = "------------------------------------------------------------------" + System.lineSeparator() +
                "Назва цукерки: Шоколадний трепет" + System.lineSeparator() +
                "Тип: печиво" + System.lineSeparator() +
                "Вага: 45.0" + System.lineSeparator() +
                "Вміст цукру: 70.0%" + System.lineSeparator();

        String actualOutput = outContent.toString();
        assertEquals(expectedOutput.intern(), actualOutput.intern());

    }

    @Test
    void addCandyToGift() throws Exception {
        List<Sweets> sweetsList = new ArrayList<>();
        sweetsList.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        sweetsList.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        List<Sweets> gift = new ArrayList<>();

        // Введення даних у вхідний потік
        String input = "1\n2\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.addCandyToGift(sweetsList, gift);

        // Очікуваний результат
        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7)); // Додана перша цукерка
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2)); // Додана друга цукерка

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Очікування виводу після додавання
        System.out.println("Цукерка 'Шоколадний трепет' додана до подарунку");
        System.out.println("Цукерка 'Карамельна мелодія' додана до подарунку");

        String expectedOutput = outContent.toString();

        // Перевірка виводу в консоль
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);

        // Перевірка, чи подарунок містить очікуваний список
        assertEquals(expectedGift,gift);
    }

    @Test
    void removeCandyFromGift() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        // Введення даних у вхідний потік
        String input = "1\nexit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.removeCandyFromGift(gift);

        // Очікуваний результат
        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7)); // Цукерка 'Карамельна мелодія' була вилучена

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Очікування виводу після вилучення
        System.out.println("Цукерка Карамельна мелодія вилучена із вашого подарунку");

        String expectedOutput = outContent.toString();

        // Перевірка виводу в консоль
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);

        // Перевірка, чи правильно була вилучена цукерка
        assertFalse(gift.contains(new CaramelCandy("Шоколадний трепет", 45.0, 0.7)));

    }

    @Test
    void calculateGiftWeight() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.calculateGiftWeight(gift);

        // Очікуваний результат
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        double expectedTotalWeight = 45.0 + 25.0; // Очікувана загальна вага

        System.out.println("Загальна вага подарунка = " + expectedTotalWeight + " грам");

        String expectedOutput = outContent.toString();

        // Перевірка виводу в консоль
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void sortCandies() {
    }

    @Test
    void findCandyBySugarContent() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        // Введення даних у вхідний потік
        String input = "0.1\n0.3\n"; // Замість "0,1\n0,3\n"
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.findCandyBySugarContent(gift);

        // Очікуваний результат
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        System.out.println("Цукерки за вмістом цукру в діапазоні [0.1;0.3]:");
        System.out.println("Карамельна мелодія - Вміст цукру: 0.2%");

        String expectedOutput = outContent.toString();

        // Перевірка виводу в консоль
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void compositionOfTheGift() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.compositionOfTheGift(gift);

        // Перевірка виводу в консоль
        String expectedOutput = "Склад вашого подарунку:" + System.lineSeparator() +
                "1. Шоколадний трепет" + System.lineSeparator() +
                "2. Карамельна мелодія" + System.lineSeparator();

        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void sortBySugarContent() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortBySugarContent(gift);

        // Очікуваний результат
        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        expectedGift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));


        // Перевірка, чи цукерки відсортовані за вмістом цукру
        assertEquals(expectedGift, gift);
    }

    @Test
    void sortByName() throws Exception {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("B", 20, 0.6));
        gift.add(new CaramelCandy("C", 15, 0.4));
        gift.add(new ChocolateCookie("A", 30, 0.5));

        // Введення даних у вхідний потік
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Виклик методу
        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortCandies(gift);

        // Перевірка, чи список gift сортується за назвою
        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new ChocolateCookie("A", 30, 0.5));
        expectedGift.add(new ChocolateCookie("B", 20, 0.6));
        expectedGift.add(new CaramelCandy("C", 15, 0.4));

        assertEquals(expectedGift, gift);
    }

    @Test
    void sortByWeight() {
        List<Sweets> gift = new ArrayList<>();
        gift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));
        gift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));

        GiftCommands giftCommands = new GiftCommands();
        giftCommands.sortByWeight(gift);

        List<Sweets> expectedGift = new ArrayList<>();
        expectedGift.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        expectedGift.add(new ChocolateCookie("Шоколадний розкіш", 40.0, 0.25));

        assertEquals(expectedGift,gift);
    }
}