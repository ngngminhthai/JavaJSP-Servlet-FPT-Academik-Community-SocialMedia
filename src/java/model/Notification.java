/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Notification {

    User reiceiver;
    User sender;
    Question source;
    String type;
    String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Notification(User sender, Question source) {
        this.sender = sender;
        this.source = source;
    }

    public Notification(User sender, Question source, String type, String createdAt) {
        this.sender = sender;
        this.source = source;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Notification(User reiceiver, User sender, Question source, String type, String createdAt) {
        this.reiceiver = reiceiver;
        this.sender = sender;
        this.source = source;
        this.type = type;
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Notification(User reiceiver, User sender, Question source) {
        this.reiceiver = reiceiver;
        this.sender = sender;
        this.source = source;
    }

    public User getReiceiver() {
        return reiceiver;
    }

    public void setReiceiver(User reiceiver) {
        this.reiceiver = reiceiver;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Question getSource() {
        return source;
    }

    public void setSource(Question source) {
        this.source = source;
    }

}
