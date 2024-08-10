package com.example.accelify.teachers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.accelify.DashboardItem;
import com.example.accelify.R;
import com.example.accelify.ViewPdfActivity;
import com.example.accelify.adapters.DashboardAdapter;

import java.util.ArrayList;
import java.util.List;

public class teachersdashboard extends AppCompatActivity {

    private GridView gridView;
    private DashboardAdapter adapter;
    private List<DashboardItem> dashboardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        gridView = findViewById(R.id.grid_view);

        // Creating a list of dashboard items
        dashboardItemList = new ArrayList<>();
        dashboardItemList.add(new DashboardItem("All results", R.drawable.ic_results));
        dashboardItemList.add(new DashboardItem("Upload PDF", R.drawable.img));
        dashboardItemList.add(new DashboardItem("View PDF", R.drawable.img_1));
        dashboardItemList.add(new DashboardItem("Coming Soon 1", R.drawable.ic_results));
//        dashboardItemList.add(new DashboardItem("Coming Soon 2", R.drawable.ic_results));
//        dashboardItemList.add(new DashboardItem("Coming Soon 3", R.drawable.ic_results));

        // Setting up the adapter
        adapter = new DashboardAdapter(this, dashboardItemList);
        gridView.setAdapter(adapter);

        // Setting up click listener for grid items
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                // Navigate to MainActivity when "Results" is clicked
//                Intent intent = new Intent(teachersdashboard.this, MainActivity.class);
//                startActivity(intent);
            }
            else if (position == 1) {
                // Navigate to UploadPdfActivity when "Upload PDF" is clicked
                Intent intent = new Intent(teachersdashboard.this, UploadPdfActivity.class);
                startActivity(intent);}
            else if (position == 2) {
                Intent intent = new Intent(teachersdashboard.this, ViewPdfActivity.class);
                startActivity(intent);
            }
        });
    }
}