package SystemDesign.CommandPattern;

public class Invoker {
    // ICommand On;
    // ICommand Off;
    Command _slot;
    boolean _isOn;
    public Invoker(Command command)
    {
        _slot = command;
        _isOn = false;
    }

    public void ButtonPressed()
    {
        if(_isOn)
            _slot.Execute();
        else
            _slot.Unexecute();

        _isOn = !_isOn;
    }

    public void ShowStatus()
    {
        _slot.ShowStatus(_isOn);
    }
}
