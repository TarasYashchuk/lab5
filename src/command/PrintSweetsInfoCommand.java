package command;

import sweets.*;

import java.util.List;

public class PrintSweetsInfoCommand implements Command{
    GiftCommands command;
    List<Sweets> sweetsList;


    public PrintSweetsInfoCommand(GiftCommands command, List<Sweets> sweetsList) {
        this.command = command;
        this.sweetsList = sweetsList;
    }

    @Override
    public void execute(){
        command.printSweetsInfo(sweetsList);
    }

    @Override
    public String getDescription() {
        return "Інформація про всі солодощі";
    }
}
