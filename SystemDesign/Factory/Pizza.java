package SystemDesign.Factory;

public class Pizza implements IFood{
    String _name;
    Double _price;
    String _style;

    public Pizza(String name, Double price, String style)
    {
        _name = name;
        _price = price;
        _style = style;
    }
    @Override
	public String getName()
    {
        System.out.println("Pizza name : " + _name);
        return _name;
    }

    @Override
    public Double getPrice()
    {
        System.out.println("Pizza price : " + _price);
        return _price;
    }

    public String getType()
    {
        System.out.println("Pizza style : " + _style);
        return _style;
    }
}
