package SystemDesign.Facade;

public class Rectangle implements IShape{
    @Override
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}