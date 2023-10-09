package Command;

import Sweets.Sweets;

import java.util.List;

public class calculateGiftWeightCommand implements Command{
    private GiftCommands command;
    private List<Sweets> gift;

    public calculateGiftWeightCommand(GiftCommands command,List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.calculateGiftWeight(gift);
    }
}
