package command;

import sweets.Sweets;

import java.util.List;

public class CompositionOfTheGiftCommand implements Command{
    GiftCommands command;
    List<Sweets> gift;

    public CompositionOfTheGiftCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.compositionOfTheGift(gift);
    }

    @Override
    public String getDescription() {
        return "Вміст подарунка";
    }
}
