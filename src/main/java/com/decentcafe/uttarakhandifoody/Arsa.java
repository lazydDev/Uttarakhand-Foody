package com.decentcafe.uttarakhandifoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Arsa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arsa);

        getSupportActionBar().hide();

    }

    public void Share(View v) {

        startActivity(new Intent(Arsa.this, MainActivity.class));

    }

}