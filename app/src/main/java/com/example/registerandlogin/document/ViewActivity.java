package com.example.registerandlogin.document;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.registerandlogin.R;
import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.apiService.JsonPlaceHolderApiFactory;
import com.example.registerandlogin.apiService.userCredentials.Credentials;
import com.example.registerandlogin.apiService.wallet.Document;
import com.example.registerandlogin.apiService.wallet.DocumentUploadService;
import com.example.registerandlogin.apiService.wallet.DocumentsGetService;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.Items;
import com.example.registerandlogin.objects.RecyclerViewList;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList <Items> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        TextView helloText = findViewById(R.id.textView);
        helloText.setText(helloText.getText().toString() + " " + Credentials.getFirstName());

        JsonPlaceHolderApi api = JsonPlaceHolderApiFactory.getApi();

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

        DocumentsGetService.getDocuments(api, Credentials.getUserId(), this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onGetUploadsSuccess(List<Document> documents) {
        ArrayList <Items> items = new ArrayList<>();

        for (Document document : documents)
            items.add(new Items(document.getUserFileName(), document.decodeFile()));

        /*
        byte[] rawImage = document.decodeFile();
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length));
        */


        recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(items, this);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }
}