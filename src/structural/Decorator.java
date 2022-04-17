package structural;

public class Decorator extends Content {
    // Object with Content type to reference the content
    private final Content contentToBeDecorated;

    Decorator(Content contentToBeDecorated) {
        this.contentToBeDecorated = contentToBeDecorated;
    }

    public void show() {
        contentToBeDecorated.show();
    }
}
