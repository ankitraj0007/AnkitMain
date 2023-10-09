package designpattern.behavioural.command;

import java.util.ArrayList;
import java.util.List;

//invoker
public class Switcher {

    List<Command> commands;

    public Switcher(){
        commands = new ArrayList<>();
    }

    public void addCommands(Command command){
        commands.add(command);
    }

    public void invokeCommands(){
        for (Command command : commands){
            command.execute();
        }
    }
}
