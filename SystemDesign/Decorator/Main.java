package SystemDesign.Decorator;

public class Main
{
    public static void main(String[] args) {
        
        ITea blackTea = new RedBeanTopping(new BubbleTopping(new BlackTea()));
        System.out.println("Total cost :" + blackTea.getCost());
        System.out.println("--------");
        ITea blackTea2 = new RedBeanTopping(new GrassGallyTopping(new BlackTea()));
        System.out.println("Total cost :" + blackTea2.getCost());
    }
}
