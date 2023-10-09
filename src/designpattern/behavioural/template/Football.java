package designpattern.behavioural.template;

public class Football extends Game{
    @Override
    protected void initializeGame() {
        System.out.println("initializing football");
    }

    @Override
    protected void playing() {
        System.out.println("playing football");
    }

    @Override
    protected void showResults() {
        System.out.println("showing results");
    }
}
