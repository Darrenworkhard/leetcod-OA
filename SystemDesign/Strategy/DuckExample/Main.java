package SystemDesign.Strategy;

public class Main{

    public static void main(String[] arg)
    {
        PlasticDuck plasticDuck = new PlasticDuck(new NoFlyStrategy());
        plasticDuck.Fly();
        plasticDuck.Display();

        Duck mountainDuck = new Duck(new FlyHighStragety());
        mountainDuck.Fly();
    }
}