package creational;//ConcreteFactory1

/**
 * The concrete factory for MS Windows
 */
public class MsWindowsWidgetFactory extends AbstractWidgetFactory {
    //create an MSWindow
    public Window createWindow(String title) {
        MSWindow window = new MSWindow(title);
        return window;
    }
}





