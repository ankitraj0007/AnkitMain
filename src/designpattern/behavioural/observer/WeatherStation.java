package designpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private int pressure;
    private int temperature;
    private int humidity;
    private List<Observer> observers;

    public WeatherStation(){
        observers = new ArrayList<>();
    }


    public void setPressure(int pressure) {
        this.pressure = pressure;
        notifyObserver();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserve(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(pressure, temperature, humidity);
        }
    }
}
