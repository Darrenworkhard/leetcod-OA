package SystemDesign.Factory;

public class FoodFactory implements IFoodFactory{

    @Override
    public IFood createFood(int catagory) {
        
        switch(catagory)
        {
            case 1 :
                return new Hotdog("Hot Dog", 50.0);
            case 2 :
                return new Pizza("Pizza", 60.0, "New York style");
            case 3 :
                return new Pizza("Pizza", 30.0, "LA style");
        }
         
        return null;
    }
    
}
