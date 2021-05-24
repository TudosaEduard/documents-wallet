package com.example.registerandlogin.document;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.registerandlogin.R;
import com.example.registerandlogin.apiService.JsonPlaceHolderApi;
import com.example.registerandlogin.apiService.JsonPlaceHolderApiFactory;
import com.example.registerandlogin.apiService.userCredentials.Credentials;
import com.example.registerandlogin.apiService.wallet.DocumentUpload;
import com.example.registerandlogin.apiService.wallet.DocumentUploadService;
import com.example.registerandlogin.login.LoginActivity;
import com.example.registerandlogin.objects.RecyclerViewList;
import com.google.android.material.textfield.TextInputLayout;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AddActivity extends AppCompatActivity {
    private DocumentUpload document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        JsonPlaceHolderApi api = JsonPlaceHolderApiFactory.getApi();

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> {
            startCropActivity();
        });

        Button btnDone = findViewById(R.id.buttonDone);
        btnDone.setOnClickListener(v -> {
            TextInputLayout name = findViewById(R.id.textName);

            document.setUserFileName(name.getEditText().getText().toString());
            DocumentUploadService.uploadDocument(api, document, this);
        });
    }

    private void startCropActivity(){
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                ImageButton myImageButton = findViewById(R.id.imageButton);
                myImageButton.setImageURI(resultUri);
                File imageFile = new File(resultUri.getPath());
                MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                        "file",
                        imageFile.getName(),
                        RequestBody.create(MediaType.parse("image/*"),
                                imageFile));
                document = new DocumentUpload(filePart, Credentials.getUserId());
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    public void onUploadSuccess() {
        Intent intent = new Intent(AddActivity.this , ViewActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left , R.anim.slide_out_right);
    }
}