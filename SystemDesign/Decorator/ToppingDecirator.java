package SystemDesign.Decorator;

public abstract class ToppingDecirator implements ITea {

    ITea _tea;

    public ToppingDecirator(ITea tea)
    {
        _tea = tea;
    }

    @Override
    public String getName() {
        return _tea.getName();
    }

    @Override
    public Double getCost() {

        Double cost = _tea.getCost();
        System.out.println("Additional cost 0.5");
        return cost + .50;
    }
    
}
