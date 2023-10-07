package Command;

public class removeCandyFromGiftCommand implements Command{
    GiftCommands command;

    public removeCandyFromGiftCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.removeCandyFromGift();
    }
}
