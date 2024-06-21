package com.example.accelify.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.accelify.R;
import com.example.accelify.models.Result;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private List<Result> resultsList;

    public ResultsAdapter(List<Result> resultsList) {
        this.resultsList = resultsList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectTextView;
        public TextView scoreTextView;

        public ViewHolder(View view) {
            super(view);
            subjectTextView = view.findViewById(R.id.subjectTextView);
            scoreTextView = view.findViewById(R.id.scoreTextView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultsList.get(position);
        holder.subjectTextView.setText(result.getSubject());
        holder.scoreTextView.setText(String.valueOf(result.getScore()));
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
