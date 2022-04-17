package creational;// Concrete product A

/**
 * The concrete product for MS Windows
 */
public class MSWindow extends Window {
    MSWindow(String text) {
        this.title = text;
    }

    public void repaint() {
        //MS Windows specific behaviour
        System.out.println("Title: " + title);
        System.out.println("Window style: MS Windows.");
    }
}






