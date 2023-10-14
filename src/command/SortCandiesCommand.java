package command;

import sweets.Sweets;

import java.util.List;

public class SortCandiesCommand implements Command {
    GiftCommands command;
    List<Sweets> gift;

    public SortCandiesCommand(GiftCommands command, List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute() throws Exception {
        command.sortCandies(gift);
    }

    @Override
    public String getDescription() {
        return "Відсортувати цукерки";
    }
}
