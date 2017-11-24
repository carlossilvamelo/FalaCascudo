package com.falacascudo.models;

/**
 * Created by carlos on 25/09/2017.
 *
 * Classe representa a entidade do dominio "Feedback", a qual contém as informações da opinião do
 * usuário que será enviada.
 *
 */

public class FeedBack {


    private String feedBackString;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * contrutor com parametros
     *
     * @param feedBackString - Texto que representa a opnião do usupário
     */
    public FeedBack(String feedBackString, User user) {
        this.feedBackString = feedBackString;
        this.user = user;
    }

    /***
     * construtor sem parametros
     */
    public FeedBack() {
    }


    public String getFeedBackString() {
        return feedBackString;
    }

    public void setFeedBackString(String feedBackString) {
        this.feedBackString = feedBackString;
    }




}
