package com.falacascudo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.falacascudo.serviceLayer.NetworkService;

/**
 * Created by carlos on 02/10/2017.
 * Esta classe é um listener de conectividade. Tendo opapel de escutar a conectividade com a rede
 * no sistema operacional e fazer o correto tratamento, chamando o devido serviço (service).
 */

public class ConnectivityChangeReceiver extends BroadcastReceiver {

    private NetworkService networkService = new NetworkService();

    @Override
    public void onReceive(Context ctx, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            if(isConnected(ctx)){
                //O código aqui é executado ao conectar
                Toast.makeText(ctx, "Conectado", Toast.LENGTH_SHORT).show();
                networkService.synchronizeDataBases();
            }else{
                //O código aqui é executado ao desconectar
                Toast.makeText(ctx, "Desconectado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isConnected(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }


}
