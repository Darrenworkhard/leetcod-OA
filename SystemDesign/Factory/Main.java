package SystemDesign.Factory;

import java.util.*;

public class Main {
    //https://medium.com/wenchin-rolls-around/%E8%A8%AD%E8%A8%88%E6%A8%A1%E5%BC%8F-%E5%B7%A5%E5%BB%A0%E8%88%87%E6%8A%BD%E8%B1%A1%E5%B7%A5%E5%BB%A0-factory-abstract-factory-design-pattern-8c28d29cb3ac
    public static void main(String[] args) {
        
        FoodFactory foodFactory = new FoodFactory();
        IFood food1 = foodFactory.createFood(1);
        IFood food2 = foodFactory.createFood(2);
        IFood food3 = foodFactory.createFood(3);

        List<IFood> list = new ArrayList<>();
        list.add(food1);
        list.add(food2);
        list.add(food3);

        for(IFood eachFood : list)
        {
            if(eachFood.getName().equals("Hot Dog"))
            {

            }
            else
            {
                Pizza p = (Pizza)eachFood;
                p.getType();

            }
        }
    }
}
