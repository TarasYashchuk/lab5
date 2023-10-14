package command;

import sweets.Sweets;

import java.util.InputMismatchException;
import java.util.List;

public class FindCandyBySugarContentCommand implements Command {
    GiftCommands command;
    List<Sweets> gift;

    public FindCandyBySugarContentCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute() throws Exception {
        command.findCandyBySugarContent(gift);
    }

    @Override
    public String getDescription() {
        return "Знайти цукерку за певним вмістом цукру";
    }
}
