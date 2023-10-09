package Command;

import Sweets.Sweets;

import java.util.List;

public class findCandyBySugarContentCommand implements Command {
    GiftCommands command;
    List<Sweets> gift;

    public findCandyBySugarContentCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute() {
        command.findCandyBySugarContent(gift);
    }
}
