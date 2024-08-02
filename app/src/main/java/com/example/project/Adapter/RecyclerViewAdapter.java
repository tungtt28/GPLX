package com.example.project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Activity.Lam_De_Thi;
import com.example.project.Models.ExamCode;
import com.example.project.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<ExamCode> examCodes;
    private Context context;

    public RecyclerViewAdapter(ArrayList<ExamCode> examCodes, Context context) {
        this.examCodes = examCodes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_examcode, parent, false);;
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(examCodes.get(position).getImage());
        holder.textView.setText(examCodes.get(position).getCode());
        holder.cardView.setOnClickListener(v -> {
            if(position == 0) {
                Intent intent = new Intent(context, Lam_De_Thi.class);
                intent.putExtra("examCode", "Đề 1");
                context.startActivity(intent);
            }else{
                Intent intent = new Intent(context,  Lam_De_Thi.class);
                intent.putExtra("examCode", "Đề 2");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return examCodes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}
