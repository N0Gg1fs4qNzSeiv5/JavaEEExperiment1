package xyz.djma.pojo;

import java.time.LocalDateTime;

/**
 * Reply实体类
 */
public class Reply {
    private int id;
    private String content;
    private LocalDateTime datetime;
    private int userId;
    private int messageId;

    public Reply() {
    }

    public Reply(int id, String content, LocalDateTime datetime, int userId, int messageId) {
        this.id = id;
        this.content = content;
        this.datetime = datetime;
        this.userId = userId;
        this.messageId = messageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", datetime=" + datetime +
                ", userId=" + userId +
                ", messageId=" + messageId +
                '}';
    }
}
