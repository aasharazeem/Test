package com.example.aasharazeem.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    private DatabaseReference mDatabase;
//FOR TEST
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onpause mthd",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        init();
        Send();
    }
    public void init(){
        //initialization function
        btn = (Button) findViewById(R.id.button);
        et1=(EditText) findViewById(R.id.name);
        et2=(EditText) findViewById(R.id.email);

    }
    public void Send(){
            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = et1.getText().toString().trim();
                String em = et2.getText().toString().trim();
                
                mDatabase.child("Name").setValue(nm);
                mDatabase.child("Email").setValue(em);
            }
        });
    }
}
