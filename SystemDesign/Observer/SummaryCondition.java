package SystemDesign.Observer;

public class SummaryCondition implements ObserverData, Display{
    private float _temp;
    private float _humidity;
    private Subject _weatherData;
    public SummaryCondition()
    {

    }

    public SummaryCondition(Subject weatherData, String name)
    {
        _weatherData = weatherData;
        _weatherData.registerObserver(this, name);

    }

    @Override
    public void display() {
        if(_temp < 85 && _humidity < 10)
            System.out.println("Good weather");
        else
            System.out.println("Hot and raining");
    }

    @Override
    public void update(float temp, float humidity) {    
        _temp = temp;
        _humidity = humidity;
        display();
    }
    
}