package com.example.email;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable {
    static int baseId = 11111;
    private int ID;
    private String sender;
    private String receiver;
    private String title;
    private String text;
    private Date date;
    private boolean important;
    private boolean read;

    public Email(String sender, String receiver, String title, String text, Date date, boolean important, boolean read){
        this.ID = baseId++;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.text = text;
        this.date = date;
        this.important = false;
        this.read = false;

    }

    public boolean isImportant() {
        return important;
    }

    public boolean isRead() {
        return read;
    }

    public Date getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }

    public static int getBaseId() {
        return baseId;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public static void setBaseId(int baseId) {
        Email.baseId = baseId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDestinationEmail(String email){
        if(email.equals(receiver)){
            return sender;

        }
        return receiver;
    }
}
