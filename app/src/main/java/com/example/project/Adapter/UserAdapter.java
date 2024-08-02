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

import com.example.project.Models.MainActivity;
import com.example.project.Models.User;
import com.example.project.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> mlistUser;
    private Context context;


    public void setData(List<User> list , Context context) {
        this.mlistUser = list;
        this.context = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlistUser.get(position);
        if(user == null) return;
        holder.imgUser.setImageResource(user.getResouceId());
        holder.tvName.setText(user.getName());
        holder.cardView_user.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("id", position);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        if (mlistUser != null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUser;
        private TextView tvName;
        private CardView cardView_user;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_name);
            cardView_user = itemView.findViewById(R.id.cardView_user);
        }
    }
}
