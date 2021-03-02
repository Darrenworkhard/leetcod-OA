package SystemDesign.CommandPattern;

public class Button {
    public boolean _on;
    public boolean _off;
    public String _name;
    public Button(String name){
        _name = name;
    }
    public void On()
    {
        _on = true;
        _off = false;
        System.out.println(_name + " Button already turn on");
    }
    public void Off()
    {
        _on = false;
        _off = true;
        System.out.println(_name + "Button already turn off");
    }
}
