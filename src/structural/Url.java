package structural;

/**
 * Contains text that's going to be decorated
 */
public class Url extends Content {
    private final String txt;

    public Url(String txt) {
        this.txt = txt;
    }

    public void show() {
        System.out.println(txt);
    }
}