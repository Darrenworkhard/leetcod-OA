package SystemDesign.Decorator;

public class RedBeanTopping extends ToppingDecirator{
    public RedBeanTopping(ITea tea) {
        super(tea);
        System.out.println("Add RedBean");
    }
}
