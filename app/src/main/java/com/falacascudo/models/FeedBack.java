package com.falacascudo.models;

/**
 * Created by carlo on 25/09/2017.
 *
 * Classe representa a entidade do dominio "Feedback", a qual contém as informações da opinião do
 * usuário que será enviada.
 *
 */

public class FeedBack {


    private String feedBackString;
    private int userType;

    /**
     * contrutor com parametros
     *
     * @param feedBackString - Texto que representa a opnião do usupário
     * @param userTipe - tipo de usuário
     */
    public FeedBack(String feedBackString, int userTipe) {
        this.feedBackString = feedBackString;
        this.userType = userTipe;
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

    public int getUserTipe() {
        return userType;
    }

    public void setUserTipe(int userTipe) {
        this.userType = userTipe;
    }


}
