package com.example.pr10keppekhov;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1, tx5, tx2, tx3, tx4, tx6;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        tx5 = (TextView)findViewById(R.id.textView5);
        tx2 = (TextView)findViewById(R.id.textview);
        tx3 = (TextView)findViewById(R.id.textView4);
        tx4 = (TextView)findViewById(R.id.textView);
        tx6 = (TextView)findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Переход...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Second.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Неправильный логин или пароль",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                        ed1.setVisibility(View.GONE);
                        ed2.setVisibility(View.GONE);
                        tx1.setVisibility(View.GONE);
                        tx5.setVisibility(View.VISIBLE);
                        tx2.setVisibility(View.GONE);
                        tx3.setVisibility(View.GONE);
                        tx4.setVisibility(View.GONE);
                        tx6.setVisibility(View.GONE);
                    }
                }
            }
        });
    }
}