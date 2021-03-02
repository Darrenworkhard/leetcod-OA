package SystemDesign.CommandPattern;

public class Command implements ICommand{

    Button _btn;
    public Command(Button btn)
    {
        _btn = btn;
    }
    @Override
    public void Execute() {
        _btn.On();
    }

    @Override
    public void Unexecute() {
        _btn.Off();
    }
    
    @Override
    public void ShowStatus(boolean isOn)
    {
        if(isOn)
            System.out.println(_btn._name + "Current Light is on");
        else
            System.out.println(_btn._name + "Current Light is off");
    }
}
