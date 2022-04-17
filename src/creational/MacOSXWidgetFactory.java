package creational;//ConcreteFactory2

/**
 * The concrete factory for Mac OS X
 */
public class MacOSXWidgetFactory extends AbstractWidgetFactory {
    //create a MacOSXWindow
    public Window createWindow(String title) {
        MacOSXWindow window = new MacOSXWindow(title);
        return window;
    }
}






