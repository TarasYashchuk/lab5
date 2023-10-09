package Command;

import Sweets.Sweets;

import java.util.List;

public class addCandyToGiftCommand implements Command {
    private GiftCommands command;
    private List<Sweets> sweetsList;
    private List<Sweets> gift;
    public addCandyToGiftCommand(GiftCommands command, List<Sweets> sweetsList, List<Sweets> gift) {
        this.command = command;
        this.sweetsList = sweetsList;
        this.gift = gift;
    }

    @Override
    public void execute() {
        command.addCandyToGift(sweetsList,gift);
    }
}
