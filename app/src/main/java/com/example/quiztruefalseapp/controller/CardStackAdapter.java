package com.example.quiztruefalseapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiztruefalseapp.R;
import com.example.quiztruefalseapp.model.QuizQuestion;
import com.example.quiztruefalseapp.view.HistoryViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    private Context mContext;
    private List<QuizQuestion> mHistoryQuestions;
    private LayoutInflater mLayoutInflater;

    public CardStackAdapter(Context context, List<QuizQuestion> historyQuestions) {
        mContext = context;
        mHistoryQuestions = historyQuestions;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.history_view, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.getTxtHistoryQuestion().setText(mHistoryQuestions.get(position).getQuestionText());

        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mHistoryQuestions.get(holder.getAdapterPosition()).isTrueAnswer()) {
                    Toast.makeText(mContext, "True is Correct!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "True is Wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mHistoryQuestions.get(holder.getAdapterPosition()).isTrueAnswer()) {
                    Toast.makeText(mContext, "False is Wrong...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "FALSE IS Correct!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHistoryQuestions.size();
    }
}
