package SystemDesign.Factory;

public class Hotdog implements IFood {

    String _name;
    Double _price;
    public Hotdog(String name, Double price)
    {
        _name = name;
        _price = price;

    }
    @Override
    public String getName() {

        System.out.println("Hotdog name : " + _name);
        return _name;
    }

    @Override
    public Double getPrice() {

        System.out.println("Hotdog price : " + _name);
        return _price;
    }
    
}
