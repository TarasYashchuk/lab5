package Command;

import Sweets.Sweets;

import java.util.List;

public class sortCandiesCommand implements Command {
    GiftCommands command;
    List<Sweets> gift;

    public sortCandiesCommand(GiftCommands command,List<Sweets> gift) {
        this.command = command;
        this.gift = gift;
    }

    @Override
    public void execute(){
        command.sortCandies(gift);
    }
}
