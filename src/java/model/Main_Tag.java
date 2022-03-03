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
public class Main_Tag {

    String tagid;
    boolean isLike;

    public Main_Tag(String tagid, boolean isLike) {
        this.tagid = tagid;
        this.isLike = isLike;
    }
    

    public boolean isIsLike() {
        return isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }
    

    public Main_Tag(String tagid) {
        this.tagid = tagid;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

}
