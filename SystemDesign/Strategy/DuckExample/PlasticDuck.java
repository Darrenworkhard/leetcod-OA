package SystemDesign.Strategy;

public class PlasticDuck extends Duck {

    IFlyBeheaver _flyBeheaver;
    public PlasticDuck(IFlyBeheaver flyBeheaver) {
        super(flyBeheaver);
    }
    
    public void Display()
    {
        System.out.println("Buy me");
    }
}
