package com.example.carlosergio.secondactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_CODE = 0;

    private Button mbtnActi;
    private EditText mMessage;
    private EditText mRepet;
    private String textAnswer;
    private TextView textAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = (EditText) findViewById(R.id.edit_message);
        mRepet = (EditText) findViewById(R.id.edit_repet);
        mbtnActi = (Button) findViewById(R.id.button);
        mbtnActi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(mMessage.getText().toString().trim().length() == 0 || mRepet.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, R.string.toast_for_message, Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = Message.newIntent(MainActivity.this, mMessage.getText().toString(),mRepet.getText().toString());
                    startActivityForResult(i, REQUEST_CODE);
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_CODE){
            if(data==null){
                return;
            }
            textAnswer = Message.wasAnswerShown(data);
            textAct = (TextView) findViewById(R.id.label_act1);
            textAct.setText(textAnswer);
        }

        }


}
