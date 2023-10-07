package Command;

public class compositionOfTheGiftCommand implements Command{
    GiftCommands command;

    public compositionOfTheGiftCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.compositionOfTheGift();
    }
}
