package com.falacascudo.serviceLayer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by carlo on 27/09/2017.
 */

public class NetworkService {

    /**
     *Estemetodo faz a verificação do estado de conectividade na rede do despositivo
     *
     * @param systemService - contexto da aplicação
     * @return connected - status da conexão
     * */
    public boolean checkNetworkAcess(Context systemService){
        boolean connected;
        ConnectivityManager conectivtyManager = (ConnectivityManager)
                systemService.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            connected = true;
        } else {
            connected = false;
        }
        return connected;

    }



    /**
     * Este metodo sincroniza o banco de dados local com o remoto, copiando os dados do banco
     * local no remoto e deletando todas as informações do banco remoto, para que não sejam
     * sincronizadas novamente, gerando redundancia.
     * */
    public void synchronizeDataBases(){}
}
