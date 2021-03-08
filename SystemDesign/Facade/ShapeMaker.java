package SystemDesign.Facade;

public class ShapeMaker {
    private IShape rectangle;
    private IShape square;
 
    public ShapeMaker() {
       rectangle = new Rectangle();
       square = new Square();
    }
    public void drawRectangle(){
       rectangle.draw();
    }
    public void drawSquare(){
       square.draw();
    }
}
