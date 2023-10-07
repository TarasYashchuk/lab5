package Command;

public class findCandyBySugarContentCommand implements Command{
    GiftCommands command;

    public findCandyBySugarContentCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.findCandyBySugarContent();
    }
}
