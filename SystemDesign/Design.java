
public class Restaurant{
  
  private FoodFactory _factory;
  private HashMap<Integer, List<Food>> _tables;
  private boolean[] _totalTable;
	public Restaurant(Factory factory, int tableCount ){
  	_facttory = factory;
    _tables = new HashMap<>();
    _totalTable = new boolean[tableCount];
  }
  public List<Integer> getVacantTable(){
  	List<Integer>  vacant = new ArrayList<>();
  	for(int i = 0;i < _totalTable.length;i++){
    	if(!t)
      	vacant.add(i);
    }
    return vacant;
  }
  public String orderMealToTable(int tableId, List<Integer> option){
  	List<Food> food = orderMealBulk(opetions);
    
    List<Food> foods =  map.getOrDefualt(tableid, food);
    map.put(tableId, foods);
    _totalTabls[i] = true;
  }
  public List<Food> deliverToTable(int tableId){
  	
  	return map.getorDefault(tableId, new ArrayList<Food>());
  }
  
	public String orderMeal(int typeofMeal){
  	Food food = _factory.getFood(typeMeal);
    return food.toString();
  }
  public List<Food> orderMealBulk(List<Integer> options){
  	List<Food> mealOrdered = new ArrayList<>();
    for(int type: options){
    	mealOrdered.add(_factory.getFood(type));
    }
    return mealOrdered;
  }
  public List<Food> orderMealByOrder(List<Integer> options, List<sequence> seq){
  	List<Food> foods =  this.orderMealBulk(options);
    if(seq.size() == foods.length)
    	return new ArrayList<>();
      
  	List<Food> order = new ArrayList<>();
    for(int s: seq){
    	order.addd(foods.get(s));
    }
		return order;    
  }
  
}
public class Table{
	public int tableId;

  public Table(int id){
  	tableId = id;

  }
}
public	class FoodFactory{
		public FoodFactory(){
    }
    public Food getFood(int type){
			switch(type):
      	case 1:
        	return new Pizza();
    	case 2: 
        	return new Steak();
        case 3: 
        	return new Salad();
    }
}

public abstract class Food{
    public String Name;
    public Decimal Pirce;
    public Food(Stirng name, Decimal price){
  	    Name = name;
        Price = price;
  }
}

public class Pizza extends Food{
	public Pizza(String name, Decimal price){
  	this.super(name, price);
  }
}

public class Steak extends Food{
	public Steak(String name, Decimal price){
  	this.super(name, price);
  }
}
public class Salad extends Food{
	public Salad(String name, Decimal price){
  	this.super(name, price);
  }
}


