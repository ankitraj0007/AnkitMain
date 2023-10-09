package designpattern.behavioural.template;

public abstract class Game {

    protected abstract void initializeGame();
    protected abstract void playing();
    protected abstract void showResults();

    public final void play(){
        initializeGame();
        playing();
        showResults();
    }

}
