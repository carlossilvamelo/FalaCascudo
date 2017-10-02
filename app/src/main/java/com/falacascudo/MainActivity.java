package com.falacascudo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.falacascudo.models.EnumUserTypes;
import com.falacascudo.models.FeedBack;
import com.falacascudo.serviceLayer.FeedBackService;
import com.falacascudo.serviceLayer.NetworkService;


public class MainActivity extends AppCompatActivity {
    public static final String DEBUG_LOG = "debug";
    //constantes utilizadas como referência para o método onActivityResult()
    public static final int SPEAK_CAPTURE_MANAGER_RESULT = 1;
    public static final int VOICE_RECOGNITION_RESULT = 2;

    //Views
    private Button buttonclickToSpeak = null;
    private Spinner spinnerOptionUserTipe = null;


    //services
    private FeedBackService feedBackService = new FeedBackService();
    private NetworkService networkService = new NetworkService();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        {//setando adapter do spinner de opções de tipo de usuário

            ArrayAdapter<String> optionsUserTipe = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item
                    , EnumUserTypes.getTypeNames());
            optionsUserTipe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerOptionUserTipe = (Spinner) findViewById(R.id.spinnerOptionsUserTipe);
            spinnerOptionUserTipe.setAdapter(optionsUserTipe);

        }//setando adapter do spinner de opções de tipo de usuário


        {//evento de botão de inicio de reconhecimento de voz

            buttonclickToSpeak = (Button) findViewById(R.id.buttonClickToSpeak);
            buttonclickToSpeak.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //intent de chamada da activity de captura e tratamento da fala
                    Intent intentOpenSpeakCaptureManagerActivity = new Intent(getApplicationContext()
                            , SpeakCaptureManagerActivity.class);
                    startActivityForResult(intentOpenSpeakCaptureManagerActivity,SPEAK_CAPTURE_MANAGER_RESULT);

                }//onClick(View v)
            });

        }//evento de botão de inicio de reconhecimento de voz



    }//onCreate


    /**
     * Este metodo recebe o resultado da activity SpeakCaptureManagerActivity, que é a activity que faz o
     * reconhecimento de voz, retornando a frase selecionada pelo usuário como frase correta.
     * O metodo...
     *
     * @param resultCode - status do resultado da resposta
     * @param requestCode - referência da resposta
     * @param data - Intent retornada da activity chamada
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Activity.RESULT_OK){
            if (requestCode == SPEAK_CAPTURE_MANAGER_RESULT) {
                String retorno = data.getStringExtra("result");
                FeedBack feedBack = new FeedBack();
                // Pedir confirmação de envio de feedback
                AlertDialog.Builder builder;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(this);
                }

                builder.setTitle("Confirmação de envio")
                        .setMessage("Deseja enviar sua opinião?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //envio confirmado
                                //chama serviço para verificar acessibilidade da rede
                                Log.d(DEBUG_LOG, "confirmFeedback() -> confirmação de envio");
                                if(networkService.checkNetworkAcess(getApplicationContext())){
                                    Log.d(DEBUG_LOG, "conexão com rede existente");
                                }else{
                                    Log.d(DEBUG_LOG, "Sem conexão com a rede");
                                }

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d(DEBUG_LOG, "confirmFeedback() -> cancelamento de envio");
                            }
                        })
                        .setIcon(R.drawable.ic_mega)
                        .show();


            }



        }else{
            Toast.makeText(getApplicationContext(), "Ocorreu um erro crítico, tente novamente!", Toast.LENGTH_LONG).show();
            //Erro no retorno da intent - pensar possibilidade de tratamento

        }
    }





}//class
