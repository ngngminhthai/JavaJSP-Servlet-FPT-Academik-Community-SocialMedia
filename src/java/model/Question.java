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
public class Question {
    int QuestionID;
    User User;
    int userID;
    String title;
    String summary;
    String createdAt;
    String content;
    int majorID;

    public Question(int questionid, String title, String summary) {
        this.title = title;
        this.summary = summary;
        this.QuestionID = questionid;
    }

    
    public Question(int QuestionID, int userID, String title, String summary, String createdAt, String content, int majorID) {
        this.QuestionID = QuestionID;
        this.userID = userID;
        this.title = title;
        this.summary = summary;
        this.createdAt = createdAt;
        this.content = content;
        this.majorID = majorID;
    }

    public Question(int QuestionID, User User, String title, String summary, String createdAt, String content, int majorID) {
        this.QuestionID = QuestionID;
        this.User= User;
        this.title = title;
        this.summary = summary;
        this.createdAt = createdAt;
        this.content = content;
        this.majorID = majorID;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User= User;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMajorID() {
        return majorID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

}
