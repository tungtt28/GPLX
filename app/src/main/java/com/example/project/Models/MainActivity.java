package com.example.project.Models;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Adapter.CategoryAdapter;
import com.example.project.R;
import com.example.project.Adapter.UserAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private RecyclerView rcvUser;
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;

    private CategoryAdapter categoryAdapter;
    private UserAdapter userAdapter;


    private void bindingView(){
        rcvCategory = findViewById(R.id.rcv_category);
        rcvUser = findViewById(R.id.rcv_user);
        drawerLayout =findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        bindingView();


        categoryAdapter = new CategoryAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvCategory.setLayoutManager(gridLayoutManager);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(false);

        categoryAdapter.setData(getListCategory(),this);
        rcvCategory.setAdapter(categoryAdapter);

        userAdapter = new UserAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setFocusable(false);
        rcvUser.setNestedScrollingEnabled(false);

        userAdapter.setData(getListUser(),this);
        rcvUser.setAdapter(userAdapter);


        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });
        View headerView = navigationView.getHeaderView(0);
        ImageView userImage = headerView.findViewById(R.id.userImage);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.navChange){
                    Toast.makeText(MainActivity.this, "Thay Đổi Hạng Lái Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navEvaluate){
                    Toast.makeText(MainActivity.this, "Đánh Giá Ứng Dụng Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navShare){
                    Toast.makeText(MainActivity.this, "Chia sẻ ứng dụng Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navFeedBack){
                    Toast.makeText(MainActivity.this, "Phản hồi và góp ý Clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navDelete){
                    Toast.makeText(MainActivity.this, "Xóa toàn bộ dữ liệu Clicked", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.close();

                return false;
            }
        });
    }

    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.storytelling,"LÀM ĐỀ THI"));
        list.add(new Category(R.drawable.bienbao,"HỌC BIỂN BÁO"));
        list.add(new Category(R.drawable.hay_sai,"50 CÂU HAY SAI"));
        list.add(new Category(R.drawable.lightbulb,"MẸO LÝ THUYẾT"));
        list.add(new Category(R.drawable.car,"BÀI THI THỰC HÀNH"));
        list.add(new Category(R.drawable.facebook,"NHÓM ÔN THI"));

        return list;

    }
    private List<User> getListUser(){
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.sharp_fmd_bad_24,"CÁC CÂU ĐIỂM LIỆT"));
        list.add(new User(R.drawable.question,"TẤT CẢ CÂU HỎI"));
        list.add(new User(R.drawable.baseline_lightbulb,"KHÁI NIỆM VÀ QUY TẮC"));
        list.add(new User(R.drawable.baseline_car_rental_24,"NGHIỆP VỤ VẬN TẢI"));
        list.add(new User(R.drawable.baseline_man_24,"VĂN HÓA VÀ ĐẠO ĐỨC LÁI XE"));
        list.add(new User(R.drawable.baseline_manage_accounts_24,"KỸ THUẬT LÁI XE"));
        list.add(new User(R.drawable.baseline_settings_24,"CẤU TẠO VÀ SỬA CHỮA"));
        list.add(new User(R.drawable.bienbao,"BIỂN BÁO ĐƯỜNG BỘ"));
        list.add(new User(R.drawable.baseline_traffic_24,"SA HÌNH"));

        return list;
    }


}