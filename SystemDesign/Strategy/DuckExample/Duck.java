package SystemDesign.Strategy;

public class Duck{

    IFlyBeheaver _flyBeheaver;
    public Duck(IFlyBeheaver flyBeheaver)
    {
        _flyBeheaver = flyBeheaver;
    }
    public void Fly()
    {
        _flyBeheaver.Fly();
    }
}
