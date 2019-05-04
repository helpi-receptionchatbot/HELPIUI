package com.example.helpiui;

public class ChatBubble {
    public String content;
    private boolean isMine;

    public ChatBubble(String content, boolean isMine) {
        this.content = content;
        this.isMine = isMine;
    }

    public String getContent() {
        return content;
    }

    public boolean isMine() {
        return isMine;
    }
}
