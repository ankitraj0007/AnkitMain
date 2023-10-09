package designpattern.behavioural.observer;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(); // subject
        WeatherObserver weatherObserver = new WeatherObserver(weatherStation); // observer

        weatherStation.setTemperature(100); // change in subject will be notified to observer
        weatherStation.setPressure(300);
        weatherStation.setHumidity(40);
    }
}
