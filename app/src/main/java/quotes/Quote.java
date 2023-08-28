package quotes;

public class Quote {
    private String[] tags;
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
        return "Quote{" +
                "tags='" + tags + '\'' +
                "author='" + author + '\'' +
                '}';
    }
}
