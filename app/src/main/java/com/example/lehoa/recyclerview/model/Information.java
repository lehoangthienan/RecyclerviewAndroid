package com.example.lehoa.recyclerview.model;

import java.util.Date;

public class Information {
    private String title , content , adress , urlIamge ;
    private long dtPost ;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Information() {
    }

    public String getAdress() {
        return adress;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setUrlIamge(String urlIamge) {
        this.urlIamge = urlIamge;
    }

    public void setDtPost(long dtPost) {
        this.dtPost = dtPost;
    }

    public String getUrlIamge() {
        return urlIamge;
    }

    public long getDtPost() {
        return dtPost;
    }

    public Information(String title, String content, String adress, String urlIamge, long dtPost) {
        this.title = title;
        this.content = content;
        this.adress = adress;
        this.urlIamge = urlIamge;
        this.dtPost = dtPost;
    }
}
