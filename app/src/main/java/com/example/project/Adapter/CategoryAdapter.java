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

import com.example.project.Activity.Bai_Thi_Thuc_Hanh;
import com.example.project.Activity.Hoc_Bien_Bao;
import com.example.project.Activity.Meo_Ly_Thuyet;
import com.example.project.Activity.SelectExamCodeActivity;
import com.example.project.Models.Category;
import com.example.project.Models.MainActivity;
import com.example.project.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private List<Category> mlistCategory;
    private Context context;


    public void setData(List<Category> list, Context context) {
        this.mlistCategory = list;
        this.context = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mlistCategory.get(position);
        if(category == null) return;
        holder.imgCategory.setImageResource(category.getResourceId());
        holder.tvTitle.setText(category.getName());
        holder.cardView.setOnClickListener(v -> {
            if(position == 0) {
                Intent intent = new Intent(context, SelectExamCodeActivity.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(context, Hoc_Bien_Bao.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
            if(position == 3){
                Intent intent = new Intent(context, Meo_Ly_Thuyet.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
            if(position == 4){
                Intent intent = new Intent(context, Bai_Thi_Thuc_Hanh.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
            if(position == 5){
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("id", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mlistCategory != null){
            return mlistCategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCategory;
        private TextView tvTitle;
        private CardView cardView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvTitle = itemView.findViewById(R.id.tv_title);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
