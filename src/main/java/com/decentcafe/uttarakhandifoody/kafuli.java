package com.decentcafe.uttarakhandifoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class kafuli extends AppCompatActivity {

    FloatingActionButton btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafuli);

        getSupportActionBar().hide();

        btnShare = findViewById(R.id.btnShare);

    }

    public void Share(View v) {

        startActivity(new Intent(kafuli.this, MainActivity.class));

    }

}