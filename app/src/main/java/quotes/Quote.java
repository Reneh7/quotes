package quotes;

import java.util.List;

public class Quote {
    private String author;
    private String body;
    private List<String> tags;
    private String likes;
    private int favorites_count;

    public String getAuthor() {
        return author;
    }
    public String getBody() {
        return body;
    }
    public List<String> getTags() {return tags;}
    public String getLikes() {return likes;}
    public int getFavoritesCount() {return favorites_count;}

    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setBody(String body)
    {
        this.body = body;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    public void setLikes(String likes)
    {
        this.likes = likes;
    }
    public void setFavoritesCount(int favoritesCount)
    {
        this.favorites_count = favoritesCount;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                ", likes='" + likes + '\'' +
                '}';
    }
}
