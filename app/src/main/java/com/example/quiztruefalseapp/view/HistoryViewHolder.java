package com.example.quiztruefalseapp.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiztruefalseapp.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    private TextView txtFilmQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        txtFilmQuestion = itemView.findViewById(R.id.history_question_text);
        imgButtonTrue = itemView.findViewById(R.id.true_button);
        imgButtonFalse = itemView.findViewById(R.id.false_button);
    }

    public TextView getTxtHistoryQuestion() {
        return txtFilmQuestion;
    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }
}
