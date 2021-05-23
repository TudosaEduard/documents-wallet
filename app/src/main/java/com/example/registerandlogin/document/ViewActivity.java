package com.example.registerandlogin.document;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.registerandlogin.R;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.Items;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList <Items> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ImageButton btnHome = findViewById(R.id.buttonHome);
        btnHome.setOnClickListener(v -> {
            startActivity(new Intent(ViewActivity.this , LoginActivity.class));
            overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
        });

        ImageButton btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(ViewActivity.this , AddActivity.class));
            overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
        });

        ArrayList <Items> items = new ArrayList<>();
        items.add(new Items("Buletin"));
        items.add(new Items("Pasaport"));
        items.add(new Items("Permis"));
        items.add(new Items("Buletin"));
        items.add(new Items("Pasaport"));
        items.add(new Items("Permis"));
        items.add(new Items("Buletin"));
        items.add(new Items("Buletin"));
        items.add(new Items("Pasaport"));
        items.add(new Items("Permis"));


        recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(items);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }
}