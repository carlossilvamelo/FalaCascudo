package com.falacascudo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlo on 25/09/2017.
 * Esta classe implementa a chamada da intent que realiza o reconhecimento de voz e
 * uma validação dos dados reconhecidos.
 */

public class SpeakCaptureManagerActivity extends VoiceRecognition {

    private ListView listViewPossibleWordList = null;
    private String selectedWords = null;
    private ArrayList<String> words = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_capture_manager_layout);



        listViewPossibleWordList = (ListView) findViewById(R.id.listViewPossibleWordList);

        {//verificando se há reconhecimento de voz
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(new
                    Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH),0);
            if(activities.size() != 0){
                //configura listener para metodo onClickSpeack() implementado na classe VoiceRecognition
                Intent intent = getRecognizerIntent();
                startActivityForResult(intent, MainActivity.VOICE_RECOGNITION_RESULT);
            }else{
                Toast.makeText(this,"Sem reconhecimento de voz",Toast.LENGTH_SHORT).show();
                //estudar melhor como tratar
                finish();
            }
        }


        {// evento de escolha da frase que será restornada
            listViewPossibleWordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result", words.get(position));
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
            });

        }// evento de escolha da frase que será restornada

    }

    /**
     * Este metodo recebe o resultado da activity VoiceRecognition, que é a activity que faz o
     * reconhecimento de voz, retornando uma lista de possiveis frases.
     * O metodo apenas seta a listView mostrando para o usuário as opções de possíveis frases e
     * pedindo que ele escolha a frase falada.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if(resultCode == Activity.RESULT_OK){
            if (requestCode == MainActivity.VOICE_RECOGNITION_RESULT) {
                // Make sure the request was successful
                listViewPossibleWordList = (ListView) findViewById(R.id.listViewPossibleWordList);
                words = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                words.add("Nenhuma das opções!");
                listViewPossibleWordList.setAdapter(new ArrayAdapter<String>(this
                        , android.R.layout.simple_list_item_activated_1, words));

            }
        }
    }


}//class
