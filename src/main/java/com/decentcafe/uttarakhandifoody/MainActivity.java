package com.decentcafe.uttarakhandifoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.decentcafe.uttarakhandifoody.Adapters.RecipeAdapter;
import com.decentcafe.uttarakhandifoody.Models.RecipeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<RecipeModel> list = new ArrayList<>();

        list.add(new RecipeModel(R.drawable.kafuli, "Kafuli"));
        list.add(new RecipeModel(R.drawable.bkc, "Bhang Ki Chutney"));
        list.add(new RecipeModel(R.drawable.gkf, "Garhwal ka Fannah"));
        list.add(new RecipeModel(R.drawable.phaanu, "Phaanu"));
        list.add(new RecipeModel(R.drawable.akj, "Aloo ka Jhol"));
        list.add(new RecipeModel(R.drawable.kks, "Kandalee Ka Saag"));
        list.add(new RecipeModel(R.drawable.aloo, "Aloo Gutuk"));
        list.add(new RecipeModel(R.drawable.dubuk, " Dubuk"));
        list.add(new RecipeModel(R.drawable.arsa, " Arsa"));

        RecipeAdapter adapter = new RecipeAdapter(list, this);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager GridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(GridLayoutManager);

    }

    public void Login(View v) {
        startActivity(new Intent(MainActivity.this, Register.class));
    }

}