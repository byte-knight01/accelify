////package com.example.accelify;
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.widget.GridView;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.example.accelify.adapters.DashboardAdapter;
////
////import java.util.ArrayList;
////import java.util.List;
////
////public class DashboardActivity extends AppCompatActivity {
////
////    private GridView gridView;
////    private DashboardAdapter adapter;
////    private List<DashboardItem> dashboardItemList;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_dashboard);
////
////        gridView = findViewById(R.id.grid_view);
////
////        // Creating a list of dashboard items
////        dashboardItemList = new ArrayList<>();
////        dashboardItemList.add(new DashboardItem("Results", R.drawable.ic_launcher_foreground)); // Placeholder icon
////        dashboardItemList.add(new DashboardItem("Coming Soon 1", R.drawable.ic_launcher_foreground)); // Placeholder icon
////        dashboardItemList.add(new DashboardItem("Coming Soon 2", R.drawable.ic_launcher_foreground)); // Placeholder icon
////        dashboardItemList.add(new DashboardItem("Coming Soon 3", R.drawable.ic_launcher_foreground)); // Placeholder icon
////
////        // Setting up the adapter
////        adapter = new DashboardAdapter(this, dashboardItemList);
////        gridView.setAdapter(adapter);
////
////        // Setting up click listener for grid items
////        gridView.setOnItemClickListener((parent, view, position, id) -> {
////            if (position == 0) {
////                // Navigate to MainActivity when "Results" is clicked
////                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
////                startActivity(intent);
////            }
////        });
////    }
////}
//
//
//
//
//
//
//package com.example.accelify;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.GridView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DashboardActivity extends AppCompatActivity {
//
//    private GridView gridView;
//    private com.example.accelify.DashboardAdapter adapter;
//    private List<DashboardItem> dashboardItemList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);
//
//        gridView = findViewById(R.id.grid_view);
//
//        // Creating a list of dashboard items
//        dashboardItemList = new ArrayList<>();
//        dashboardItemList.add(new DashboardItem("Results", R.drawable.ic_launcher_foreground)); // Placeholder icon
//        dashboardItemList.add(new DashboardItem("Coming Soon 1", R.drawable.ic_launcher_foreground)); // Placeholder icon
//        dashboardItemList.add(new DashboardItem("Coming Soon 2", R.drawable.ic_launcher_foreground)); // Placeholder icon
//        dashboardItemList.add(new DashboardItem("Coming Soon 3", R.drawable.ic_launcher_foreground)); // Placeholder icon
//
//        // Setting up the adapter
//        adapter = new com.example.accelify.DashboardAdapter(this, dashboardItemList);
//        gridView.setAdapter(adapter);
//
//        // Setting up click listener for grid items
//        gridView.setOnItemClickListener((parent, view, position, id) -> {
//            if (position == 0) {
//                // Navigate to MainActivity when "Results" is clicked
//                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}



package com.example.accelify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.accelify.adapters.DashboardAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private GridView gridView;
    private DashboardAdapter adapter; 
    private List<DashboardItem> dashboardItemList;
    private Button btnsignout;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        gridView = findViewById(R.id.grid_view);
        btnsignout = findViewById(R.id.btn_sign_out);


        auth = FirebaseAuth.getInstance();
        // Creating a list of dashboard items
        dashboardItemList = new ArrayList<>();

        dashboardItemList.add(new DashboardItem("Results", R.drawable.img_2));
        dashboardItemList.add(new DashboardItem("DPP", R.drawable.img_1));
        dashboardItemList.add(new DashboardItem("Coming Soon 1", R.drawable.ic_results));
        dashboardItemList.add(new DashboardItem("Coming Soon 2", R.drawable.ic_results));
//        dashboardItemList.add(new DashboardItem("Coming Soon 3", R.drawable.ic_results));

        // Setting up the adapter
        adapter = new DashboardAdapter(this, dashboardItemList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                // Navigate to MainActivity when "Results" is clicked
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else if (position == 1) {
                // Navigate to ViewPdfActivity when "View PDFs" is clicked
                Intent intent = new Intent(DashboardActivity.this, ViewPdfActivity.class);
                startActivity(intent);
            }
        });



        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out the user
                auth.signOut();
                // Redirect to login screen after sign-out
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  // Close the dashboard activity
            }
        });







    }
}

//@Override
//public void onBackPressed() {
//    // Instead of finishing the activity, minimize the app
//    moveTaskToBack(true);
//}
