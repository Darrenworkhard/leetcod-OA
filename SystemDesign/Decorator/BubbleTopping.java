package SystemDesign.Decorator;

public class BubbleTopping extends ToppingDecirator{

    public BubbleTopping(ITea tea) {
        super(tea);
        System.out.println("Add Bubble");
    }
}
