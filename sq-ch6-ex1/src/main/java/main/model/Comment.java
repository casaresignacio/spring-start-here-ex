package main.model;

public class Comment {
    private String text;
    private String author;

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setAuthor(String author) {
        this.author = author;
    }
}
