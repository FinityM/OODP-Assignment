package creational;

/**
 * The concrete factory for Unix
 * */
public class UnixWindowsWidgetFactory extends AbstractWidgetFactory {

    @Override
    public Window createWindow(String title) {
        UnixWindow window = new UnixWindow(title);
        return window;
    }
}
