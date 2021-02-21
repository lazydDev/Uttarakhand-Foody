package com.decentcafe.uttarakhandifoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dubuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dubuk);

        getSupportActionBar().hide();

    }

    public void Share(View v) {

        startActivity(new Intent(Dubuk.this, MainActivity.class));

    }

}