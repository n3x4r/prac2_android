package com.example.carlosergio.secondactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.secondapp.MESSAGE";
    public final static String EXTRA_REPET = "com.example.secondapp.REPET";

    private Button mbtnActi;
    private EditText mMessage;
    private EditText mRepet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnActi = (Button) findViewById(R.id.button);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Message.class);
        mMessage = (EditText) findViewById(R.id.edit_message);
        mRepet = (EditText) findViewById(R.id.edit_repet);

        intent.putExtra(EXTRA_MESSAGE, mMessage.getText().toString());
        intent.putExtra(EXTRA_REPET, Integer.parseInt(mRepet.getText().toString()));

        startActivity(intent);
    }


}
