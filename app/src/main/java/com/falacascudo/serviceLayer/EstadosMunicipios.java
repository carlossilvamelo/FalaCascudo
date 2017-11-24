package com.falacascudo.serviceLayer;

import com.falacascudo.R;

import java.util.ArrayList;

/**
 * Created by carlo on 23/10/2017.
 */

public class EstadosMunicipios {

    private String estado;
    private ArrayList<String> municipios;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<String> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<String> municipios) {
        this.municipios = municipios;
    }

    public EstadosMunicipios(String estado, String[] municipios) {
        this.estado = estado;
        ArrayList<String> list = new ArrayList<String>();
        for (String s:municipios) {
            list.add(s);
        }
        this.municipios = list;
    }



}
