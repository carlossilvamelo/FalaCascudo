package com.falacascudo.models;

/**
 * Created by carlo on 25/09/2017.
 */

public class FeedBack {


    private String feedBackString;
    private int userTipe;

    /**
     * constructor with parameters
     */
    public FeedBack(String feedBackString, int userTipe) {
        this.feedBackString = feedBackString;
        this.userTipe = userTipe;
    }

    /***
     *
     */
    public FeedBack() {
    }

    public String getFeedBackString() {
        return feedBackString;
    }

    public void setFeedBackString(String feedBackString) {
        this.feedBackString = feedBackString;
    }

    public int getUserTipe() {
        return userTipe;
    }

    public void setUserTipe(int userTipe) {
        this.userTipe = userTipe;
    }


}
