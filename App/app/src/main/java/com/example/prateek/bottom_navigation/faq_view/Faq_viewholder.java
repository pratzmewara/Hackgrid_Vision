package com.example.prateek.bottom_navigation.faq_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kartikbhardwaj.bottom_navigation.R;


public class Faq_viewholder extends RecyclerView.ViewHolder {
    TextView question;
    TextView answer;
    String question_string;
    String answer_string;



    public Faq_viewholder(@NonNull View itemView) {
        super(itemView);
        question=itemView.findViewById(R.id.question);
        answer=itemView.findViewById(R.id.answer);

    }

    public void populate(FaqModal faq){
        question_string=faq.getQuestion();
        answer_string=faq.getAnswer();
        question.setText(question_string);
        answer.setText(answer_string);
    }
}
