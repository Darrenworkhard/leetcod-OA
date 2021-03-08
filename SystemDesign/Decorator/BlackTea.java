package SystemDesign.Decorator;

public class BlackTea implements ITea{
    String _name;
    Double _cost;
    public BlackTea()
    {
        _name = "Black Tea";
        _cost = 6.0;
        System.out.println("Order Black Tea");
    }
    @Override
    public String getName() {
       return _name;
        
    }
    @Override
    public Double getCost() {

        System.out.println("Black Tea cost 6.0");
        return _cost;
    }

    
}
