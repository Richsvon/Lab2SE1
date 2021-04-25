package com.example.lab2se1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ATM extends AppCompatActivity {

    TextView balance;
    EditText amount;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbr;
    Button withdraw, deposit;
    float actualBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        withdraw = findViewById(R.id.withdrawButton);
        deposit = findViewById(R.id.depositButton);
        balance = findViewById(R.id.balance);
        amount = findViewById(R.id.amountEditText);
        String key = getIntent().getStringExtra("key");
        dbr = database.getReference("User/" + key);
        updateBalance();


        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withdraw();
            }
        });

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit();
            }
        });
    }

    public void deposit(){
        float newBalance = actualBalance + Float.parseFloat(amount.getText().toString());
        dbr.child("balance").setValue(newBalance);
        updateBalance();
    }

    public void withdraw() {
        float newBalance = actualBalance - Float.parseFloat(amount.getText().toString());
        dbr.child("balance").setValue(newBalance);
        updateBalance();
    }


    public void updateBalance() {
        dbr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                actualBalance = Float.parseFloat(snapshot.child("balance").getValue().toString());
                balance.setText(snapshot.child("balance").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}