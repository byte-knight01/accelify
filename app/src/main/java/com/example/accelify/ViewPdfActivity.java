package com.example.accelify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ViewPdfActivity extends AppCompatActivity {

    private ListView pdfListView;
    private List<String> pdfUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfListView = findViewById(R.id.pdfListView);
        pdfUrls = new ArrayList<>();

        StorageReference storageReference = FirebaseStorage.getInstance().getReference("pdfs");
        storageReference.listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    pdfUrls.add(uri.toString());
                    displayPdfs();
                });
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(ViewPdfActivity.this, "Failed to load PDFs: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        });

        pdfListView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            String url = pdfUrls.get(position);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(url), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        });
    }

    private void displayPdfs() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pdfUrls);
        pdfListView.setAdapter(adapter);
    }
}
