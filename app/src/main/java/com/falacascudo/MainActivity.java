package com.falacascudo;

import android.app.Activity;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;


import com.falacascudo.dataLayer.LocalDataBase;
import com.falacascudo.models.EnumEscolaridade;
import com.falacascudo.models.EnumEstadosMunicipios;
import com.falacascudo.models.EnumUserTypes;
import com.falacascudo.models.FeedBack;
import com.falacascudo.serviceLayer.EstadosMunicipios;
import com.falacascudo.serviceLayer.FeedBackService;
import com.falacascudo.serviceLayer.LocalPersistence;
import com.falacascudo.serviceLayer.NetworkService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final String DEBUG_LOG = "debug";
    //constantes utilizadas como referência para o método onActivityResult()
    public static final int SPEAK_CAPTURE_MANAGER_RESULT = 1;
    public static final int VOICE_RECOGNITION_RESULT = 2;
    public static FeedBack feedBack = new FeedBack();
    //Views
    private static RadioGroup rgVisitaEscolar = null;
    private static RadioGroup rgProfAluno = null;
    private static RadioButton rbSim = null;
    private static RadioButton rbNao = null;
    private static RadioButton rbAluno = null;
    private static RadioButton rbProfessor = null;
    private static RatingBar ratingBarNota = null;

    private static LinearLayout layoutProfAluno; //layout que contem os componentes textview e radioGroup
    private static LinearLayout layoutEscolaridade; //layout que contem os componentes textview e radioGroup
    private static Spinner spinnerEscolaridade = null;
    private static AutoCompleteTextView autoCompleteCountry = null;
    private static AutoCompleteTextView autoCompleteEstado = null;
    private static AutoCompleteTextView autoCompleteMunicio = null;

    //services
    private FeedBackService feedBackService = new FeedBackService();
    private NetworkService networkService = new NetworkService();

    private static EnumEstadosMunicipios enumEstadosMunicipios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        enumEstadosMunicipios = EnumEstadosMunicipios.RN;

        layoutEscolaridade = (LinearLayout) findViewById(R.id.layoutEscolaridade);
        layoutProfAluno = (LinearLayout) findViewById(R.id.layoutProfAluno);
        rbSim = (RadioButton) findViewById(R.id.rbSim);
        rbNao = (RadioButton) findViewById(R.id.rbNao);
        rbAluno = (RadioButton) findViewById(R.id.rbAluno);
        rbProfessor = (RadioButton) findViewById(R.id.rbProfessor);
        ratingBarNota = (RatingBar) findViewById(R.id.ratingBarNota);
        spinnerEscolaridade = (Spinner) findViewById(R.id.spinnerEscolaridade);
        autoCompleteCountry = (AutoCompleteTextView) findViewById(R.id.autoCompleteCountry);
        autoCompleteEstado = (AutoCompleteTextView) findViewById(R.id.autoCompleteEstado);
        autoCompleteMunicio = (AutoCompleteTextView) findViewById(R.id.autoCompleteMunicio);

        {//setando adapter dos paises
            List<String> countryList = Arrays.asList(getResources().getStringArray(R.array.countries));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, countryList);
            autoCompleteCountry.setAdapter(adapter);
            autoCompleteCountry.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().equals("Brasil") || s.toString().equals("brasil")) {
                        autoCompleteEstado.setVisibility(View.VISIBLE);
                        autoCompleteMunicio.setVisibility(View.VISIBLE);
                    } else {
                        autoCompleteEstado.setVisibility(View.INVISIBLE);
                        autoCompleteMunicio.setVisibility(View.INVISIBLE);
                    }
                }
            });

        }

        {//setando adapter dos estados
            // List<String> municipiosList =  Arrays.asList(getResources().getStringArray(R.array.RN));

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, enumEstadosMunicipios.listaEstados());
            autoCompleteEstado.setAdapter(adapter);
            autoCompleteEstado.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View v, boolean hasFocus) {

                    if (hasFocus) {

                        Log.i("focus", "focus");

                    }
                }
            });
        }

        {//setando adapter dos municipios
            //  List<String> countryList =  Arrays.asList(getResources().getStringArray(R.array.countries));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, enumEstadosMunicipios.getMunicipios());
            autoCompleteMunicio.setAdapter(adapter);
            autoCompleteMunicio.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View v, boolean hasFocus) {

                    if (hasFocus) {
                        //this if condition is true when edittext lost focus...
                        //check here for number is larger than 10 or not
                        //editText.setText("10");
                        Log.i("focus", "focus");
                    }
                }
            });
        }

        {//listener radioGroup visita escolar
            rgVisitaEscolar = (RadioGroup) findViewById(R.id.rgVisitaEscolar);
            RadioButton checkedRadioButton = (RadioButton) rgVisitaEscolar
                    .findViewById(rgVisitaEscolar.getCheckedRadioButtonId());
            rgVisitaEscolar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // This will get the radiobutton that has changed in its check state
                    RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                    // This puts the value (true/false) into the variable
                    boolean isChecked = checkedRadioButton.isChecked();
                    // If the radiobutton that has changed in check state is now checked...
                    if (isChecked) {
                        if (checkedRadioButton.getText().equals("Sim")) {
                            layoutProfAluno.setVisibility(View.VISIBLE);
                        } else {
                            layoutProfAluno.setVisibility(View.INVISIBLE);
                            layoutEscolaridade.setVisibility(View.INVISIBLE);
                            rbProfessor.setChecked(false);
                            rbAluno.setChecked(true);
                        }
                    }
                }
            });
        }


        {//rgProfAluno
            rgProfAluno = (RadioGroup) findViewById(R.id.rgProfAluno);
            RadioButton checked = (RadioButton) rgProfAluno.findViewById(rgProfAluno.getCheckedRadioButtonId());
            rgProfAluno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // This will get the radiobutton that has changed in its check state
                    RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                    // This puts the value (true/false) into the variable
                    boolean isChecked = checkedRadioButton.isChecked();
                    // If the radiobutton that has changed in check state is now checked...
                    if (isChecked) {
                        if (checkedRadioButton.getText().equals("Professor")) {
                            layoutEscolaridade.setVisibility(View.VISIBLE);
                        } else {
                            layoutEscolaridade.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            });
        }


        {
            ArrayAdapter<String> adapterEscolaridade = new ArrayAdapter<String>(this
                    , android.R.layout.simple_spinner_item,EnumEscolaridade.getNamesList());
            adapterEscolaridade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerEscolaridade.setAdapter(adapterEscolaridade);
        }


    }//onCreate


    public static final int RESULT_FEEDBACK = 1000;

    public void inserirFeedBack(View view) {

        Intent intent = new Intent(this, FeedBackActivity.class);
        startActivityForResult(intent, RESULT_FEEDBACK);
    }

    private static AlertDialog alert;

    /**
     *
     *
     * */
    public void saveData(String feedBackText) {
        //tratamento dos view
        if (autoCompleteCountry != null) {
            Log.i("saveData", "pais: " + autoCompleteCountry.getText());
        }
        if (autoCompleteEstado != null) {
            Log.i("saveData", "estado: " + autoCompleteEstado.getText());
        }
        if (autoCompleteMunicio != null) {
            Log.i("saveData", "municipio: " + autoCompleteMunicio.getText());
        }

        RadioButton checkedVisitaEscolar = (RadioButton) rgVisitaEscolar
                .findViewById(rgVisitaEscolar.getCheckedRadioButtonId());

        if (checkedVisitaEscolar != null) {
            Log.i("saveData", "checkedVisitaEscolar: " + checkedVisitaEscolar.getText());
        }


        RadioButton checkedProfAluno = (RadioButton) rgProfAluno.findViewById(rgProfAluno.getCheckedRadioButtonId());
        if (checkedProfAluno != null) {
            Log.i("saveData", "checkedProfAluno: " + checkedProfAluno.getText());
        }

        if (ratingBarNota != null) {
            Log.i("saveData", "ratingBarNota: " + ratingBarNota.getRating());
        }

        Log.i("saveData", "feedBackText: " + feedBackText);
        //dialog de fechamendo de feedBacck
        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.confirmation_layout, null);
        view.findViewById(R.id.btFinalizar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        alert = builder.create();
        alert.show();


    }


    private void clearView() {

        if (autoCompleteCountry != null) {
            autoCompleteCountry.setText("");
        }
        if (autoCompleteEstado != null) {
            autoCompleteEstado.setText("");
        }
        if (autoCompleteMunicio != null) {
            autoCompleteMunicio.setText("");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == RESULT_FEEDBACK) {

                String result = data.getStringExtra("result");
                Log.i("mainResult", "Retorno com sucesso: " + result);
                LayoutInflater li = getLayoutInflater();
                View view = li.inflate(R.layout.confirmation_layout, null);
                view.findViewById(R.id.btFinalizar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(view);
                builder.setTitle("Confirmação de envio");
                alert = builder.create();
                alert.show();
                saveData(result);

            }
        } else {
            Log.i("mainResult", "Retorno inválido");
        }

    }//onActivityResult


}//class
