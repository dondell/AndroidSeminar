package com.dmj.newworld.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dmj.newworld.R;
import com.dmj.newworld.adapter.UserListAdapter;
import com.dmj.newworld.base.BaseActivity;
import com.dmj.newworld.model.UserModel;

import java.util.ArrayList;

public class UserListActivity extends BaseActivity {

    private RecyclerView recyclerViewUsers;
    private UserListAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.activity_userlist;
    }

    @Override
    public void init() {
        //Add dummy data
        ArrayList<UserModel> userModelArrayList = new ArrayList<>();
        UserModel userModel1 = new UserModel("John", "Lao", "johnlao@gmail.com");
        userModelArrayList.add(userModel1);
        UserModel userModel2 = new UserModel("AJ");
        userModelArrayList.add(userModel2);

        //Create adapter
        adapter = new UserListAdapter(userModelArrayList);

        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsers.setAdapter(adapter);
    }
}
