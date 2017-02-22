package com.example.carlosergio.secondactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String EXTRA_MESSAGE = "com.example.secondapp.MESSAGE";
    private final static String EXTRA_REPET = "com.example.secondapp.REPET";

    private Button mbtnActi;
    private EditText mMessage;
    private EditText mRepet;

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

                if(mMessage.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this, "The message is empty", Toast.LENGTH_SHORT).show();
                }if((mRepet.getText().toString().trim().length() == 0)){
                    Toast.makeText(MainActivity.this, "The number of repete is empty", Toast.LENGTH_SHORT).show();
                }else {
                    Intent newIntent = new Intent(MainActivity.this, Message.class);
                    newIntent.putExtra(EXTRA_MESSAGE, mMessage.getText().toString());
                    newIntent.putExtra(EXTRA_REPET, mRepet.getText().toString());
                    startActivity(newIntent);
                }
            }
        });
    }
    /*
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Message.class);
        mMessage = (EditText) findViewById(R.id.edit_message);
        mRepet = (EditText) findViewById(R.id.edit_repet);

        //intent.putExtra(EXTRA_MESSAGE, mMessage.getText().toString());
        intent.putExtra(EXTRA_REPET, Integer.parseInt(mRepet.getText().toString()));


        startActivity(intent);
    }*/


}
