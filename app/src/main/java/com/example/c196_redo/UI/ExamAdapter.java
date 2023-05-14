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
            examItemView = itemView.findViewById(R.id.examLayView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final Exam current = mExams.get(position);
                    Intent intent = new Intent(context, ExamList.class);
                    intent.putExtra("name", current.getExamName());
                    intent.putExtra("start", current.getStartDate());
                    intent.putExtra("end", current.getEndDate());
                    intent.putExtra("notes", current.getExamNotes());
                    intent.putExtra("id", current.getExamID());
                    context.startActivity(intent);
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
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.exam_list_layout, parent, false);
        return new ExamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ExamViewHolder holder, int position) {
        if (mExams != null) {
            Exam current = mExams.get(position);
            String name = current.getExamName();
            holder.examItemView.setText(name);
        } else {
      //      holder.examItemView.setText("No exam name");
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
