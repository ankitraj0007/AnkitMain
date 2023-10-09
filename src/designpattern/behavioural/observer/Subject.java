package designpattern.behavioural.observer;

public interface Subject {

    public void addObserver(Observer observer);
    public void removeObserve(Observer observer);
    public void notifyObserver();

}
