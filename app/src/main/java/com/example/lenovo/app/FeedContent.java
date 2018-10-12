package com.example.lenovo.app;

public class FeedContent {
    private int idEvent, idUser, Upvote, Downvote, idPlace, idGroup, idType;
    private String Name, Start_Time, End_Time, Link, Image, Place;

    public FeedContent() {
        this.idUser = 1;
        this.idPlace = 1;
        this.idGroup = 1;
        this.idType = 1;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getLink() {
        return Link;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getUpvote() {
        return Upvote;
    }

    public void setUpvote(int upvote) {
        Upvote = upvote;
    }

    public int getDownvote() {
        return Downvote;
    }

    public void setDownvote(int downvote) {
        Downvote = downvote;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
