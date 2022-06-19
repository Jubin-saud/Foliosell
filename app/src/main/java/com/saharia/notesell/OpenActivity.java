package com.saharia.notesell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.saharia.notesell.Activities.LoginActivity;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread td = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intent = new Intent(OpenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}