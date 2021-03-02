package SystemDesign.CommandPattern;

public class CommandPattern {
    
    public static void main(String[] args) {
        Button apple = new Button("Apple");
        Button tesla = new Button("Teala");

        Invoker invokerApple = new Invoker(new Command(apple));
        Invoker invokerTesla = new Invoker(new Command(tesla));
        
        invokerApple.ButtonPressed();
        invokerApple.ButtonPressed();
        invokerApple.ButtonPressed();
        invokerApple.ButtonPressed();
        invokerTesla.ButtonPressed();
        invokerTesla.ButtonPressed();
        invokerTesla.ButtonPressed();

        invokerApple.ShowStatus();
        invokerTesla.ShowStatus();
    }
}
