package com.example.abhi.prakitianalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PrakritiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prakriti_result);

        String s =  getIntent().getStringExtra("result");

        Toast.makeText(this, "s = "+s, Toast.LENGTH_SHORT).show();
    }
}
