package com.falacascudo.models;

import java.util.ArrayList;

/**
 * Created by carlo on 20/11/2017.
 */

public enum EnumEscolaridade {

    FUNDAMENTAL_INCOMPLETO("Fundamental - Incompleto"),
    FUNDAMENTAL_COMPLETO("Fundamental - Completo"),
    MEDIO_INCOMPLETO("Médio - Incompleto"),
    MEDIO_COMPLETO("Médio - Completo"),
    SUPERIOR_INCOMPLETO("Superior - Incompleto"),
    SUPERIOR_COMPLETO("Superior - Completo"),
    POSGRADUACAO_INCOMPLETO("Pós-graduação - Incompleto"),
    POSGRADUACAO_COMPLETO("Pós-graduação - Completo");


    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    EnumEscolaridade(String value) {
        this.value = value;
    }

    public static ArrayList<String> getNamesList(){
        ArrayList<String> list = new ArrayList<String>();

        for (EnumEscolaridade escolaridade: EnumEscolaridade.values()) {
            list.add(escolaridade.getValue());
        }
        return list;
    }

}
