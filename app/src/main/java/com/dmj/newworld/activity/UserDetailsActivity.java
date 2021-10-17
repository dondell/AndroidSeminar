package com.dmj.newworld.activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.dmj.newworld.R;
import com.dmj.newworld.base.BaseActivity;
import com.dmj.newworld.model.user.UserModel;
import com.dmj.newworld.model.user.UserViewModel;

public class UserDetailsActivity extends BaseActivity {

    private UserModel userModel;
    private TextView textViewFirstnameVal;
    private TextView textViewLastnameVal;
    private TextView textViewEmailVal;
    private Button buttonDelete;

    private UserViewModel userViewModel;

    @Override
    public int setLayout() {
        return R.layout.activity_user_details;
    }

    @Override
    public void init() {
        setActivityTitle("User Details", true);

        textViewFirstnameVal = findViewById(R.id.textViewFirstnameVal);
        textViewLastnameVal = findViewById(R.id.textViewLastnameVal);
        textViewEmailVal = findViewById(R.id.textViewEmailVal);
        buttonDelete = findViewById(R.id.buttonDelete);

        //Get user data from previous screen.
        userModel = getIntent().getParcelableExtra("userData");

        if (userModel != null) {
            textViewFirstnameVal.setText(userModel.firstname);
            textViewLastnameVal.setText(userModel.lastname);
            textViewEmailVal.setText(userModel.email);
        } else {
            Toast.makeText(UserDetailsActivity.this, "This data is not valid", Toast.LENGTH_SHORT).show();
        }

        //Connect CRUD
        userViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(UserViewModel.class);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.deleteUser(textViewEmailVal.getText().toString());
                finish();
                Toast.makeText(UserDetailsActivity.this, "User deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }
        return true;
    }
}
