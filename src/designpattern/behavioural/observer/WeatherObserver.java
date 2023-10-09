package designpattern.behavioural.observer;

public class WeatherObserver implements Observer{
    private int pressure;
    private int temperature;
    private int humidity;
    private Subject subject;

    public WeatherObserver(Subject subject){
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature, int humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
        show();
    }

    private void show(){
        System.out.println("WeatherObserver{" +
                "pressure=" + pressure +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}');
    }

}
