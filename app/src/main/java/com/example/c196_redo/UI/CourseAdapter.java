package com.example.c196_redo.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196_redo.Entities.Course;
import com.example.c196_redo.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {


    class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView courseItemView;
        private TextView courseItemView2;

        private CourseViewHolder(View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.textView4);
            courseItemView2 = itemView.findViewById(R.id.textView5);
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {


                    int position = getAdapterPosition();
                    final Course current = mCourses.get(position);
                    Intent intent = new Intent(context, CourseDetails.class);
                    intent.putExtra("id", current.getCourseID());
                    intent.putExtra("name", current.getCourseName());
                    intent.putExtra("start", current.getStartDate());
                    intent.putExtra("end", current.getEndDate());
                    intent.putExtra("term", current.getTermID());
                    intent.putExtra("notes", current.getCourseNotes());
                    context.startActivity(intent);
                }
            });
        }
    }

    private final Context context;
    private final LayoutInflater mInflater;
    private List<Course> mCourses;

    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_layout, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if (mCourses != null) {
            Course current = mCourses.get(position);
            String name = current.getCourseName();
            int termID = current.getTermID();
            holder.courseItemView.setText(name);
            holder.courseItemView2.setText(Integer.toString(termID));
        } else {
            holder.courseItemView.setText("No part name");
            holder.courseItemView.setText("No product id");
        }
    }


    public void setCourses(List<Course> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

}
