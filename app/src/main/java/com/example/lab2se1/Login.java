package com.example.lab2se1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button loginButton;
    EditText username, password;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbr = database.getReference("User");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.LoginButton);
        username = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account(username.getText().toString(), password.getText().toString(), 0);
                dbr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean login = false;
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            Account compareAccount = ds.getValue(Account.class);
                            if (account.getUsername().equals(compareAccount.getUsername()) && account.getPassword().equals(compareAccount.getPassword())) {
                                login = true;
                                Intent intent = new Intent(Login.this, ATM.class);
                                intent.putExtra("key", ds.getKey());
                                startActivity(intent);
                            }
                        }
                        if (!login) {
                            Toast.makeText(Login.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
                            username.setText("");
                            password.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}