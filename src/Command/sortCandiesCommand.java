package Command;

public class sortCandiesCommand implements Command {
    GiftCommands command;

    public sortCandiesCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.sortCandies();
    }
}
