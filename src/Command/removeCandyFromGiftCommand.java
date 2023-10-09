package Command;

import Sweets.Sweets;

import java.util.List;

public class removeCandyFromGiftCommand implements Command{
    GiftCommands command;
    List<Sweets> gift;

    public removeCandyFromGiftCommand(GiftCommands command,List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.removeCandyFromGift(gift);
    }
}
