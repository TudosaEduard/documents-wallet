package com.example.registerandlogin.document;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registerandlogin.R;

public class ViewPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_document);

        ImageView imageView = findViewById(R.id.image);
        byte[] rawImage = (byte[]) getIntent().getSerializableExtra("rawPhoto");
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length));
    }
}
