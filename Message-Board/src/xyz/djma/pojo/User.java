package xyz.djma.pojo;

import java.util.List;

/**
 * User实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private List<Message> messages;
    private List<Reply> replies;

    public User() {
    }

    public User(int id, String username, String password, List<Message> messages, List<Reply> replies) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.messages = messages;
        this.replies = replies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", messages=" + messages +
                ", replies=" + replies +
                '}';
    }
}
