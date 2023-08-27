package quotes;

public class Quote {
    private String author;
    private String text;

    public String getAuthor() {
        return author;
    }
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Quote" + text+'\'' +
                "author='" + author + '\'';
    }
}
