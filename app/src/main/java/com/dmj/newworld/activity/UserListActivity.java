package com.dmj.newworld.activity;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dmj.newworld.R;
import com.dmj.newworld.adapter.UserListAdapter;
import com.dmj.newworld.base.BaseActivity;
import com.dmj.newworld.model.user.UserModel;
import com.dmj.newworld.model.user.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UserListActivity extends BaseActivity {

    private RecyclerView recyclerViewUsers;
    private FloatingActionButton actionButton;
    private UserListAdapter adapter;
    private ArrayList<UserModel> userModelArrayList = new ArrayList<>();
    private UserViewModel userViewModel;

    @Override
    public int setLayout() {
        return R.layout.activity_userlist;
    }

    @Override
    public void init() {
        setActivityTitle("User List", false);
        //Add dummy data
        /*UserModel userModel1 = new UserModel("John", "Lao", "johnlao@gmail.com");
        userModelArrayList.add(userModel1);
        UserModel userModel2 = new UserModel("AJ");
        userModelArrayList.add(userModel2);*/

        //Create adapter
        adapter = new UserListAdapter(UserListActivity.this, userModelArrayList);

        //Connect CRUD
        userViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(UserViewModel.class);

        //Listen to changes in user table
        userViewModel.getAllUsers().observe(UserListActivity.this, list -> {
            userModelArrayList.clear();
            userModelArrayList.addAll(list);
            adapter.notifyDataSetChanged();
        });

        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsers.setAdapter(adapter);

        actionButton = findViewById(R.id.fabAdd);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog(userViewModel, "Add user");
            }
        });


    }
}
