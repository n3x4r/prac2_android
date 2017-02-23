package com.example.carlosergio.secondactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Message extends AppCompatActivity {
    private final static String EXTRA_MESSAGE = "com.example.secondapp.MESSAGE";
    private final static String EXTRA_REPET = "com.example.secondapp.REPET";
    private final static String EXTRA_ANSWER = "com.example.secondapp.ANSWER";
    private String mMessage;
    private String nRept;
    private String mMessageToShow="";
    private TextView mtext;
    private Button btnBackAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mMessage = getIntent().getStringExtra(EXTRA_MESSAGE);
        nRept = getIntent().getStringExtra(EXTRA_REPET);
        mtext = (TextView) findViewById(R.id.label_act2);
        for(int i = 0; i < Integer.parseInt(nRept); i++){
            mMessageToShow += mMessage+" ";
        }

        mtext.setText(mMessageToShow);

        btnBackAc = (Button) findViewById(R.id.button_back_actv2);
        btnBackAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextResult(mtext.getText().toString());
                finish();
            }
        });
    }

    public static Intent newIntent(Context packContext, String text1, String text2){
        Intent i = new Intent(packContext, Message.class);
        i.putExtra(EXTRA_MESSAGE, text1);
        i.putExtra(EXTRA_REPET, text2);
        return i;
    }

    public void setTextResult(String text){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER, text);
        setResult(RESULT_OK, data);
    }

    public static String wasAnswerShown(Intent result){
        return result.getStringExtra(EXTRA_ANSWER);
    }

}
