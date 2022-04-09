package creational;//Client
/**
 * Client class to actually use the
 * factory classes to build the user
 * interface.
 * This class will be handled by the abstract factory
 *
 * */
public class GUIBuilder{
  public void buildWindow(AbstractWidgetFactory widgetFactory, String title){
    Window window = widgetFactory.createWindow(title);
    window.repaint();
  }
}




