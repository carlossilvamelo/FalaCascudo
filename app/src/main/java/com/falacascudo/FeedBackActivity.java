package com.falacascudo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity {

    private static EditText textFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        textFeedback = (EditText) findViewById(R.id.textFeedback);
        if(textFeedback == null){
            Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_LONG);
        }


    }

    public void enviarFeedback(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",textFeedback.getText()+"");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

    public void reconhecimentoVoz(View view) {
        Intent intentOpenSpeakCaptureManagerActivity = new Intent(getApplicationContext()
                , SpeakCaptureManagerActivity.class);
        startActivityForResult(intentOpenSpeakCaptureManagerActivity, MainActivity.SPEAK_CAPTURE_MANAGER_RESULT);
    }

    /**
     * Este metodo recebe o resultado da activity SpeakCaptureManagerActivity, que é a activity que faz o
     * reconhecimento de voz, retornando a frase selecionada pelo usuário como frase correta.
     * O metodo...
     * @param resultCode  - status do resultado da resposta
     * @param requestCode - referência da resposta
     * @param data        - Intent retornada da activity chamada
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == MainActivity.SPEAK_CAPTURE_MANAGER_RESULT) {
                String retorno = data.getStringExtra("result");


                if(!retorno.equals(SpeakCaptureManagerActivity.INVALID_OPTION)){
                    //FeedBack feedBack = new FeedBack();
                    MainActivity.feedBack.setFeedBackString(retorno);
                    String textEditText = textFeedback.getText() + " " + retorno;
                    textFeedback.setText(textEditText);
                }




            }


        } else {
            Toast.makeText(getApplicationContext(), "Ocorreu um erro crítico, tente novamente!", Toast.LENGTH_LONG).show();
            //Erro no retorno da intent - pensar possibilidade de tratamento

        }
    }


}
