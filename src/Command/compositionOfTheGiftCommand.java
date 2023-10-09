package Command;

import Sweets.Sweets;

import java.util.List;

public class compositionOfTheGiftCommand implements Command{
    GiftCommands command;
    List<Sweets> gift;

    public compositionOfTheGiftCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.compositionOfTheGift(gift);
    }
}
