package SystemDesign.Observer;
import java.util.*;

public interface Subject {
    public void registerObserver(ObserverData o, String name);
    public void removeObserver(ObserverData o, String name);
    public void notifyObserver();
}
