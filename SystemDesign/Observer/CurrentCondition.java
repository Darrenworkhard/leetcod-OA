package SystemDesign.Observer;

import java.util.*;

public class CurrentCondition implements ObserverData, Display{
    private float _temp;
    private float _humidity;
    private Subject _weatherData;
    public CurrentCondition()
    {

    }
    public CurrentCondition(Subject weatherData, String name)
    {
        _weatherData = weatherData;
        _weatherData.registerObserver(this, name);

    }

    @Override
    public void display() {
        System.out.println("Hi everyone, we have a new weather Temp : " + _temp + " Humidity : " + _humidity);
    }

    @Override
    public void update(float temp, float humidity) {    
        _temp = temp;
        _humidity = humidity;
        display();
    }
    
}
