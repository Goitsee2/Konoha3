package com.example.edugive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Decider extends AppCompatActivity {
    TextView school;
    TextView donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);

        school = findViewById(R.id.d_school);
        donor = findViewById(R.id.d_donor);

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decider.this, SignUp.class);
                startActivity(intent);
            }
        });
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decider.this, Donor.class);
                startActivity(intent);
            }
        });
    }
}