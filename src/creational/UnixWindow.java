package creational;

/**
 * The concrete product for Unix
 */
public class UnixWindow extends Window {
    UnixWindow(String text) {
        this.title = text;
    }

    @Override
    public void repaint() {
        System.out.println("Title: " + title);
        System.out.println("Window style: Unix");
    }
}
