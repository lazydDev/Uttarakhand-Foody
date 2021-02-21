package com.decentcafe.uttarakhandifoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.decentcafe.uttarakhandifoody.R;

public class Bhang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhang);

        getSupportActionBar().hide();

    }

    public void Share (View v) {

        startActivity(new Intent(Bhang.this, MainActivity.class));

    }

}