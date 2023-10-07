package Command;

public class printSweetsInfoCommand implements Command{
    GiftCommands command;

    public printSweetsInfoCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.printSweetsInfo();
    }
}
