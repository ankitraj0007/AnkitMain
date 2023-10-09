package designpattern.behavioural.template;

public class BasketBall extends Game{
    @Override
    protected void initializeGame() {
        System.out.println("initializing BasketBall");
    }

    @Override
    protected void playing() {
        System.out.println("playing BasketBall");
    }

    @Override
    protected void showResults() {
        System.out.println("showing BasketBall");
    }
}
