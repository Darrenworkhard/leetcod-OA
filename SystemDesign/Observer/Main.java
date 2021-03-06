package SystemDesign.Observer;
import java.util.*;

public class Main{

    public static void main(String[] arg)
    {
        WeatherData weatherData = new WeatherData();

        //SummaryCondition summary = new SummaryCondition(weatherData , "SummaryCondition");
        //CurrentCondition current = new CurrentCondition(weatherData , "CurrentCondition");  

        weatherData.registerObserver(new SummaryCondition(weatherData , "SummaryCondition"),  "SummaryCondition");
        weatherData.registerObserver(new CurrentCondition(weatherData , "CurrentCondition"),  "CurrentCondition");
        weatherData.setMeasurement(75, 0);

        weatherData.setMeasurement(95, 90);
    }
}