package com.example.accelify.teachers;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.accelify.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

    public class UploadPdfActivity extends AppCompatActivity {

        private static final int PICK_PDF_REQUEST = 1;
        private StorageReference storageReference;
        private Button uploadButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upload_pdf);

            storageReference = FirebaseStorage.getInstance().getReference("pdfs");

            uploadButton = findViewById(R.id.uploadButton);
            uploadButton.setOnClickListener(v -> openFileChooser());
        }

        private void openFileChooser() {
            Intent intent = new Intent();
            intent.setType("application/pdf");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, PICK_PDF_REQUEST);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri pdfUri = data.getData();
                uploadFile(pdfUri);
            }
        }

        private void uploadFile(Uri pdfUri) {
            if (pdfUri != null) {
                StorageReference fileReference = storageReference.child(System.currentTimeMillis() + ".pdf");
                fileReference.putFile(pdfUri)
                        .addOnSuccessListener(taskSnapshot -> {
                            Toast.makeText(UploadPdfActivity.this, "Upload successful", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(UploadPdfActivity.this, "Upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            }
        }
    }


