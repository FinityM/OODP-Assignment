package creational;// Concrete product B

/**
 * The concrete product for Mac OS X
 */
public class MacOSXWindow extends Window {
    MacOSXWindow(String text) {
        this.title = text;
    }

    public void repaint() {
        //Mac OSX specific behaviour
        System.out.println("Title: " + title);
        System.out.println("Window style: Mac OSX.");
    }
}






