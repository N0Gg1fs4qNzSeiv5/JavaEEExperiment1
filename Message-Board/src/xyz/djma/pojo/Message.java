package xyz.djma.pojo;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Message实体类
 */
public class Message {
    private int id;
    private String title;
    private String content;
    @Expose
    private LocalDateTime datetime;
    private int userId;
    private List<Reply> replies;

    public Message() {
    }

    public Message(int id, String title, String content, LocalDateTime datetime, int userId, List<Reply> replies) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datetime = datetime;
        this.userId = userId;
        this.replies = replies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", datetime=" + datetime +
                ", userId=" + userId +
                ", replies=" + replies +
                '}';
    }
}
