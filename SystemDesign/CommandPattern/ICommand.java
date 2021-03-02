package SystemDesign.CommandPattern;

public interface ICommand {
    public void Execute();
    public void Unexecute();
    public void ShowStatus(boolean isOn);
    //public void Undo();
}
