package com.example.carlosergio.secondactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Message extends AppCompatActivity {
    private final static String EXTRA_MESSAGE = "com.example.secondapp.MESSAGE";
    private final static String EXTRA_REPET = "com.example.secondapp.REPET";
    private String mMessage;
    private String nRept;
    private String mMessageToShow="";
    private TextView mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mMessage = getIntent().getStringExtra(EXTRA_MESSAGE);//false porque es el valor antes de que le pasen el verdadero valor
        nRept = getIntent().getStringExtra(EXTRA_REPET);
        mtext = (TextView) findViewById(R.id.text_label);
        for(int i = 0; i < Integer.parseInt(nRept); i++){
            mMessageToShow += mMessage+" ";
        }

        mtext.setText(mMessageToShow);


    }
    /*
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE_CHAT){

        }
    }*/
}
