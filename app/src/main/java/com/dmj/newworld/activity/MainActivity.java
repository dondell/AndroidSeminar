package com.dmj.newworld.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmj.newworld.R;
import com.dmj.newworld.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private TextView textView;
    private EditText editTextPersonName;
    private Button button;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        textView = findViewById(R.id.textView);
        textView.setText("Hi AJ");

        editTextPersonName = findViewById(R.id.editTextPersonName);

        button = findViewById(R.id.button);

        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editTextPersonName.getText().toString());
            }
        });
    }
}