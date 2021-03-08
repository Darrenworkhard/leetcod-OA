package SystemDesign.Strategy.FoodExample;

public class Main {
    public static void main(String[] args) {
        Food burger = new Food(new HelfCook());
        Food hotdog = new Food(new HotCook());

        burger.howToCook();
        hotdog.howToCook();
    }
}
