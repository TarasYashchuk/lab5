package Command;

public class addCandyToGiftCommand implements Command {
    GiftCommands command;

    public addCandyToGiftCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
     command.addCandyToGift();
    }
}
