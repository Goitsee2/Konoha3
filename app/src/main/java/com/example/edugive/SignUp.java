package com.example.edugive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    Button reg;

public class SignUp extends AppCompatActivity {
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firestore=FirebaseFirestore.getInstance();
        EditText Principle=(EditText) findViewById(R.id.principalname) ;
        EditText School=(EditText) findViewById(R.id.schoolname) ;
        EditText SchoolEmail=(EditText) findViewById(R.id.email_address);
        EditText Registratrion=(EditText) findViewById(R.id.regno) ;
        EditText Pass=(EditText) findViewById(R.id.sign_up_pass) ;
        EditText SchoolTel=(EditText) findViewById(R.id.schoolno) ;
        ImageView SchoolImg=(ImageView) findViewById(R.id.imageButton2) ;


        Button btn2=(Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PrinName=Principle.getText().toString();
                String SchoolName=School.getText().toString();
                String Reg=Registratrion.getText().toString();
                String Password=Pass.getText().toString();
                String Tel=SchoolTel.getText().toString();

                Map<String,Object> Schools=new HashMap<>();
                Schools.put("Principle",PrinName);
                Schools.put("School",SchoolName);
                Schools.put("Registration Number",Reg);
                Schools.put("Password",Password);
                Schools.put("Telephone",Tel);

                firestore.collection("Schools").add(Schools).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent goToSchool=new Intent(SignUp.this,School.class);
                        startActivity(goToSchool);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Whoops, something went wrong while signing up",Toast.LENGTH_LONG).show();
                    }
                });




        reg = findViewById(R.id.button2);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
            }
        });
    }
}
