package Command;

public class User {

    Command addCandyToGift;
    Command calculateGiftWeight;
    Command compositionOfTheGift;
    Command findCandyBySugarContent;
    Command printSweetsInfo;
    Command removeCandyFromGift;
    Command sortCandies;

    public User(Command addCandyToGift, Command calculateGiftWeight, Command compositionOfTheGift, Command findCandyBySugarContent, Command printSweetsInfo, Command removeCandyFromGift, Command sortCandies) {
        this.addCandyToGift = addCandyToGift;
        this.calculateGiftWeight = calculateGiftWeight;
        this.compositionOfTheGift = compositionOfTheGift;
        this.findCandyBySugarContent = findCandyBySugarContent;
        this.printSweetsInfo = printSweetsInfo;
        this.removeCandyFromGift = removeCandyFromGift;
        this.sortCandies = sortCandies;
    }

    public void addCandyToGiftRecord(){
        addCandyToGift.execute();
    }

    public void calculateGiftWeightRecord(){
        calculateGiftWeight.execute();
    }

    public void compositionOfTheGiftRecord(){
        compositionOfTheGift.execute();
    }

    public void findCandyBySugarContentRecord(){
        findCandyBySugarContent.execute();
    }

    public void printSweetsInfoRecord(){
        printSweetsInfo.execute();
    }

    public void removeCandyFromGiftRecord(){
        removeCandyFromGift.execute();
    }

    public void sortCandiesRecord(){
        sortCandies.execute();
    }
}
