package Command;

import java.util.Map;

public class User {

    private Map<String, Command> commands;

    public User(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Немає команди з назвою " + commandName);
        }
    }
}
