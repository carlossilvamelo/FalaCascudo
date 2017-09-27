package com.falacascudo.models;

import java.util.ArrayList;

/**
 * Created by carlo on 27/09/2017.
 *
 * Esta enumeração representa os tipos de usuários possíveis. Tipos de visitantes do museu
 */

public enum EnumUserTypes {
    VISITANTE("Visitante"),
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    GESTOR_DE_ESCOLA("Gestor de escola");

    private String name;

    private EnumUserTypes(String nome) {
        this.name = nome;
    }


    /**
     *
     * */
    public static String getTypeById(Integer id){
        for (EnumUserTypes cores : EnumUserTypes.values()) {
            if(EnumUserTypes.valueOf(cores.toString()).ordinal() == id){
                return EnumUserTypes.valueOf(cores.toString()).toString();
            }
        }
        return null;
    }

    /***/
    public Integer getId(){
        return this.ordinal();
    }

    /***/
    public String getTypeNameById(Integer idType){
        return EnumUserTypes.getTypeById(idType).toString();
    }

    /***/
    public static ArrayList<String> getTypeNames(){
        ArrayList<String> list = new ArrayList<String>();
        for (EnumUserTypes type : EnumUserTypes.values()) {
            list.add(type.toString());
        }
        return list;
    }
}//class
