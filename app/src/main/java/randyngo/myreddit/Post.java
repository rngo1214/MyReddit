package randyngo.myreddit;

public class Post {
    private String title;
    private String author;
    private String date_updated;
    private String postURL;
    private String thumhnailURL;

    public Post(String title, String author, String date_updated, String postURL, String thumhnailURL) {
        this.title = title;
        this.author = author;
        this.date_updated = date_updated;
        this.postURL = postURL;
        this.thumhnailURL = thumhnailURL;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public String getPostURL() {
        return postURL;
    }

    public String getThumhnailURL() {
        return thumhnailURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public void setPostURL(String postURL) {
        this.postURL = postURL;
    }

    public void setThumhnailURL(String thumhnailURL) {
        this.thumhnailURL = thumhnailURL;
    }


}
