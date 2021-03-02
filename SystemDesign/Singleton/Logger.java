package SystemDesign.Singleton;

public class Logger {
    private static Logger _logger;
    private Logger()
    {

    }

    public static Logger LoggerExecute()
    {
        if(_logger == null)
        {
            _logger = new Logger();
        }

        return _logger;
    }

    public void ShowVersion()
    {
        System.out.println("Logger version is 10.1");
    } 

    public void ShowAuther()
    {
        System.out.println("Darren");
    }
}
