package com.falacascudo;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by carlo on 25/09/2017.
 * <p>
 * Classe implementa o reconhecimento de voz cia API Speech to Texto
 */

public class VoiceRecognition extends AppCompatActivity {


    /**
     * este metodo deve ser sobreescrito na classe filha, configurando a acitivity
     * como desejado
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Metodo listener para o botão que chama o reconhecimento de voz
     */
    protected View.OnClickListener onClickSpeak() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getRecognizerIntent();
                startActivityForResult(intent, 0);

            }
        };
    }

    /**
     * Metodo de configuração da intent chamada para o reconhecimento de voz
     */
    protected Intent getRecognizerIntent() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL
                , RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "fale algo");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 30);
        //testes
        // intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);
        // intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, 5000);
        // intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 5000);

        return intent;

    }


    /**
     * Metodo deve ser sobreescrito na flasse filha desta classe, para recuperar a lista
     * de possiveis palavras capturadas no reconhecimento de voz
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
