package SystemDesign.Strategy;

public class NoFlyStrategy implements IFlyBeheaver{
    @Override
    public void Fly()
    {
        System.out.println("I don't know how to fly");
    }
}
