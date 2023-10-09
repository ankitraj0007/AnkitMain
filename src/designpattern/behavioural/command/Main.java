package designpattern.behavioural.command;

//client
public class Main {

    public static void main(String[] args) {
        //command, receiver, invoker, client

        Switcher switcher = new Switcher(); //invoker

        Light light = new Light(); // receiver

        TurnOnCommand turnOnCommand = new TurnOnCommand(light); // command
        TurnOffCommand turnOffCommand = new TurnOffCommand(light); //command

        switcher.addCommands(turnOnCommand);
        switcher.addCommands(turnOffCommand);

        switcher.invokeCommands();
    }
}
