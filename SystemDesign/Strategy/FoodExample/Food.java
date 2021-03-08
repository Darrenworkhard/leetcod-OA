package SystemDesign.Strategy.FoodExample;

public class Food {
    ICookBeheaver _cookBeheaver;
    public Food(ICookBeheaver cookBeheaver)
    {
        _cookBeheaver = cookBeheaver;
    }

    public void howToCook()
    {
        System.out.println("This is the way to cook : ");
        _cookBeheaver.cook();
    }
}
