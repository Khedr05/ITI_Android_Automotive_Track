package com.example.sms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editPhone;
    private EditText editMessage;
    private Button nextBtn;
    private Button closeBtn;
    public static final String PHONE = "PHONE";
    public static final String MESSAGE = "MESSAGE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPhone = findViewById(R.id.phoneEditTxt);
        editMessage = findViewById(R.id.messageEditTxt);
        nextBtn = findViewById(R.id.nextBtn);
        closeBtn = findViewById(R.id.closeBtn);



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(MainActivity.this,ActivityTwo.class);
                String phone = editPhone.getText().toString();
                String msg = editMessage.getText().toString();
                outIntent.putExtra(MainActivity.PHONE,phone);
                outIntent.putExtra(MainActivity.MESSAGE,msg);
                startActivity(outIntent);
            }
        });




    }

    public void onClose(View view) {
        finish();
    }
}