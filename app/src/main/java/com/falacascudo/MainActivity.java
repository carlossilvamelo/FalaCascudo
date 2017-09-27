package com.falacascudo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.falacascudo.models.EnumUserTypes;
import com.falacascudo.models.FeedBack;


public class MainActivity extends AppCompatActivity {

    public static final int SPEAK_CAPTURE_MANAGER_RESULT = 1;
    public static final int VOICE_RECOGNITION_RESULT = 2;
    private Button buttonclickToSpeak = null;
    private Spinner spinnerOptionUserTipe = null;


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
     *
     *
     * @param resultCode - status do resultado da resposta
     * @param requestCode - referência da resposta
     * @param data - Intent retornada da activity chamada
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Activity.RESULT_OK){
            if (requestCode == SPEAK_CAPTURE_MANAGER_RESULT) {
                String retorno = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), retorno, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_SHORT).show();
            //Erro no retorno da intent - tratar!
        }
    }
}
