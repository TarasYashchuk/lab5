package Command;

import Sweets.*;

import java.util.List;

public class printSweetsInfoCommand implements Command{
    GiftCommands command;
    List<Sweets> sweetsList;


    public printSweetsInfoCommand(GiftCommands command, List<Sweets> sweetsList) {
        this.command = command;
        this.sweetsList = sweetsList;
    }

    @Override
    public void execute(){
        command.printSweetsInfo(sweetsList);
    }
}
