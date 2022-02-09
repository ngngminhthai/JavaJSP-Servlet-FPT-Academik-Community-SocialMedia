/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Comment {

    int questionID;
    int userID;
    String content;
    String createdAt;
    User user;

    public Comment(int questionID, int userID, String content, String createdAt) {
        this.questionID = questionID;
        this.userID = userID;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment(int questionID, User user, String content, String createdAt) {
        this.questionID = questionID;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
