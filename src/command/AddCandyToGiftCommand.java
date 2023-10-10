package command;

import sweets.Sweets;

import java.util.List;

public class AddCandyToGiftCommand implements Command {
    private GiftCommands command;
    private List<Sweets> sweetsList;
    private List<Sweets> gift;
    public AddCandyToGiftCommand(GiftCommands command, List<Sweets> sweetsList, List<Sweets> gift) {
        this.command = command;
        this.sweetsList = sweetsList;
        this.gift = gift;
    }

    @Override
    public void execute() {
        command.addCandyToGift(sweetsList,gift);
    }

    @Override
    public String getDescription() {
        return "Додати цукерку до подарунка";
    }
}
