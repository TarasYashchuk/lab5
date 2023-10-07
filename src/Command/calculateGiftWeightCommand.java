package Command;

public class calculateGiftWeightCommand implements Command{
    GiftCommands command;

    public calculateGiftWeightCommand(GiftCommands command) {
        this.command = command;
    }

    @Override
    public void execute(){
        command.calculateGiftWeight();
    }
}
