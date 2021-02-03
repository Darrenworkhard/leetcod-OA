package SystemDesign.Observer;

import java.util.*;

public class WeatherData implements Subject {
    private HashMap<String, ObserverData> _map;
    private float _temp;
    private float _humidity;

    public WeatherData()
    {
        _map = new HashMap();
    }

    @Override
    public void registerObserver(ObserverData o, String name) {
        _map.put(name, o);
    }

    @Override
    public void removeObserver(ObserverData o, String name) {
        _map.remove(name);

    }

    @Override
    public void notifyObserver() {
        for(String s : _map.keySet())
        {
            ObserverData observer = _map.get(s);
            observer.update(_temp, _humidity);
        }

    }

    public void measureChange()
    {
        notifyObserver();
    }

    public void setMeasurement(float temp, float humididy)
    {
        _temp = temp;
        _humidity = humididy;
        measureChange();
    }
    




}
