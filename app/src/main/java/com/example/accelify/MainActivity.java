//package com.example.accelify;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.accelify.adapters.ResultsAdapter;
//import com.example.accelify.models.Result;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private FirebaseFirestore db;
//    private RecyclerView recyclerView;
//    private ResultsAdapter resultsAdapter;
//    private List<Result> resultsList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize Firestore
//        db = FirebaseFirestore.getInstance();
//
//        // Initialize UI elements
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        resultsList = new ArrayList<>();
//        resultsAdapter = new ResultsAdapter(resultsList);
//        recyclerView.setAdapter(resultsAdapter);
//
//        // Fetch results from Firestore
//        fetchResults();
//    }
//
//    private void fetchResults() {
//        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        Log.d("FetchResults", "User ID: " + userId);
//
//        if (userId != null) {
//            // Query Firestore to get results for the current user
//            db.collection("results")
//                    .whereEqualTo("studentId", userId)
//                    .get()
//                    .addOnSuccessListener(queryDocumentSnapshots -> {
//                        if (queryDocumentSnapshots.isEmpty()) {
//                            Log.d("FetchResults", "No matching documents.");
//                        } else {
//                            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
//                                Log.d("FetchResults", "Document data: " + document.getData());
//                                Result result = document.toObject(Result.class);
//                                resultsList.add(result);
//                                // Log the result for debugging
//                                Log.d("FetchResults", "Fetched result: " + result.getSubject() + ", Score: " + result.getScore());
//                            }
//                        }
//                        resultsAdapter.notifyDataSetChanged();
//                        // Log the size of resultsList
//                        Log.d("FetchResults", "Total results fetched: " + resultsList.size());
//                    })
//                    .addOnFailureListener(exception -> {
//                        Toast.makeText(MainActivity.this, "Error fetching results: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.e("FetchResults", "Error fetching results", exception);
//                    });
//        } else {
//            Toast.makeText(MainActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
//            Log.e("FetchResults", "User not authenticated");
//        }
//    }
//}


package com.example.accelify;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.accelify.adapters.ResultsAdapter;
import com.example.accelify.models.Result;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private ResultsAdapter resultsAdapter;
    private List<Result> resultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // Initialize UI elements
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        resultsList = new ArrayList<>();
        resultsAdapter = new ResultsAdapter(resultsList);
        recyclerView.setAdapter(resultsAdapter);

        // Fetch results from Firestore
        fetchResults();
    }

    private void fetchResults() {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.d("FetchResults", "User ID: " + userId);  // Log the user ID

        if (userId != null) {
            // Get the document with the userId as the document ID
            db.collection("results").document(userId).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            Map<String, Object> data = documentSnapshot.getData();
                            if (data != null) {
                                for (Map.Entry<String, Object> entry : data.entrySet()) {
                                    String subject = entry.getKey();
                                    int score = ((Long) entry.getValue()).intValue();
                                    Result result = new Result(subject, score);
                                    resultsList.add(result);
                                    Log.d("FetchResults", "Fetched result: " + subject + ", Score: " + score);
                                }
                            }
                        } else {
                            Log.d("FetchResults", "No document found.");
                        }
                        resultsAdapter.notifyDataSetChanged();
                        Log.d("FetchResults", "Total results fetched: " + resultsList.size());
                    })
                    .addOnFailureListener(exception -> {
                        Toast.makeText(MainActivity.this, "Error fetching results: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("FetchResults", "Error fetching results", exception);
                    });
        } else {
            Toast.makeText(MainActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
            Log.e("FetchResults", "User not authenticated");
        }
    }
}
