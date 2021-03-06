package SystemDesign.Adapter;

public class Hero implements IHero{
    
    @Override
    public void Attack()
    {
        System.out.println("I'm a hero attack from origianl version");

    }
}
