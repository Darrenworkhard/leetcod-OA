package SystemDesign.Decorator;

public class GrassGallyTopping extends ToppingDecirator{

    ITea _tea;
    public GrassGallyTopping(ITea tea) {
        super(tea);
        //TODO Auto-generated constructor stub
        _tea = tea;

        System.out.println("Add GrassGally");
    }
    
    @Override
    public Double getCost()
    {
        Double cost = _tea.getCost();
        System.out.println("Additional cost 1.0");
        return cost + 1.0;
    }
}
