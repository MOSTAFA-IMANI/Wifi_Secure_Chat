package com.rymon.exampel.wifi_encrypted_messaging.Models;



public class ChatMessage {
    public boolean left;
    public String plainText;
    public String SHA256;
    public String encryptedText;

    public ChatMessage(boolean left, String plainText) {
        super();
        this.left = left;
        this.plainText = plainText;
    }
}