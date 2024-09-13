package homework3.ex5;

import java.time.LocalDateTime;

public class Feedback {
    private Integer id;
    private String text;
    private Integer likes;
    private LocalDateTime date;

    public Feedback(Integer id, String text, Integer likes, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.likes = likes;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", likes=" + likes +
                ", date=" + date +
                '}';
    }
}
