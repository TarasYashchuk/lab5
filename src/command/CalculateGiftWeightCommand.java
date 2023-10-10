package command;

import sweets.Sweets;

import java.util.List;

public class CalculateGiftWeightCommand implements Command{
    private GiftCommands command;
    private List<Sweets> gift;

    public CalculateGiftWeightCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.calculateGiftWeight(gift);
    }
    @Override
    public String getDescription() {
        return "Вага всього подарунка";
    }
}
