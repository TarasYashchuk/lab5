package command;

import sweets.Sweets;

import java.util.List;

public class RemoveCandyFromGiftCommand implements Command{
    GiftCommands command;
    List<Sweets> gift;

    public RemoveCandyFromGiftCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.removeCandyFromGift(gift);
    }

    @Override
    public String getDescription() {
        return "Вилучити цукерку з подарунка";
    }
}
