package com.dmj.newworld.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.dmj.newworld.R;
import com.dmj.newworld.model.user.UserModel;
import com.dmj.newworld.model.user.UserViewModel;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        init();
    }

    @LayoutRes
    public abstract int setLayout();

    public abstract void init();

    public void setActivityTitle(String screenTitle, boolean isBackButton) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(screenTitle);
            //actionBar.setHomeButtonEnabled(isBackButton);
            actionBar.setDisplayHomeAsUpEnabled(isBackButton);
        }
    }

    public void showSimpleDialog(UserViewModel userViewModel, String title) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog_add_user, null);
        dialogBuilder.setCancelable(true);
        dialogBuilder.setView(dialogView);

        TextView textViewTitle = dialogView.findViewById(R.id.textViewTitle);
        textViewTitle.setText(title);

        EditText editTextFirstname = dialogView.findViewById(R.id.editTextFirstname);
        EditText editTextLastname = dialogView.findViewById(R.id.editTextLastname);
        EditText editTextEmailname = dialogView.findViewById(R.id.editTextEmailname);

        AlertDialog alertDialog = dialogBuilder.create();

        Button buttonOk = dialogView.findViewById(R.id.buttonAdd);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user = new UserModel();
                user.firstname = editTextFirstname.getText().toString();
                user.lastname = editTextLastname.getText().toString();
                user.email = editTextEmailname.getText().toString();
                userViewModel.insert(user);

                alertDialog.dismiss();
                Toast.makeText(BaseActivity.this, "User added successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();

    }
}
