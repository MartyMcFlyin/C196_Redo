package com.example.c196_redo.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196_redo.Entities.Exam;
import com.example.c196_redo.R;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {

    private List<Exam> mExams;
    private final Context context;
    private final LayoutInflater mInflater;


    class ExamViewHolder extends RecyclerView.ViewHolder {
        private TextView examItemView;

        private ExamViewHolder(View itemView) {
            super(itemView);
            examItemView = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final Exam current = mExams.get(position);
                    Intent intent = new Intent(context, ExamList.class);
                    intent.putExtra("Name", current.getExamName());
                    intent.putExtra("Start", current.getStartDate());
                    intent.putExtra("Start", current.getEndDate());
                    intent.putExtra("Notes", current.getExamNotes());
                    intent.putExtra("ID", current.getExamID());

                }
            });
        }
    }

    public void setExams(List<Exam> exams) {
        mExams = exams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExamAdapter.ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_exam_list, parent, false);
        return new ExamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ExamViewHolder holder, int position) {
        if (mExams != null) {
            Exam current = mExams.get(position);
            String name = current.getExamName();
            holder.examItemView.setText(name);
        } else {
            holder.examItemView.setText("No exam name");
        }
    }

    @Override
    public int getItemCount() {
        if (mExams != null) {
            return mExams.size();
        } else {
            return 0;
        }
    }

    public ExamAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

}
