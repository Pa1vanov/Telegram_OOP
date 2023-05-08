package jk.uz.pdp.model;

import java.time.LocalDateTime;

public class Message extends BaseModel {
    private String text;
    private Long fromId;
    private Long toId;

    public Message(String text, Long fromId, Long toId) {
        this.text = text;
        this.fromId = fromId;
        this.toId = toId;
    }

    public Message() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }
}
