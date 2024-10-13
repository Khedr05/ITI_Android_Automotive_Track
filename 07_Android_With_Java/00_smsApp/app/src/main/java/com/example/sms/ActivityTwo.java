package com.example.sms;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityTwo extends AppCompatActivity {

    private static final String PREFS_NAME = "PREFS_NAME";
    private static final String FILE_NAME = "FILE_NAME";

    private Button backBtn;
    private Button btnWsh;
    private Button btnRsh;
    private Button btnRIs;
    private Button btnWIs;
    private Button btnSqlW;
    private Button btnSqlR;

    private DataBaseAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView txtPhone = findViewById(R.id.phoneTxtViewa2);
        TextView txtMessage = findViewById(R.id.msgTxtView);
        backBtn = findViewById(R.id.backBtn);
        btnRsh = findViewById(R.id.spRBtn);
        btnWsh = findViewById(R.id.spWBtn);
        btnRIs = findViewById(R.id.isRBtn);
        btnWIs = findViewById(R.id.isWBtn);
        btnSqlR = findViewById(R.id.sqlRBtn);
        btnSqlW = findViewById(R.id.sqlWBtn);

        dbAdapter = new DataBaseAdapter(this);

        Intent incomingIntent = getIntent();
        txtPhone.setText(incomingIntent.getStringExtra(MainActivity.PHONE));
        txtMessage.setText(incomingIntent.getStringExtra(MainActivity.MESSAGE));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnWsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(MainActivity.PHONE, txtPhone.getText().toString());
                editor.putString(MainActivity.MESSAGE, txtMessage.getText().toString());
                editor.apply();
                txtPhone.setText("");
                txtMessage.setText("");
                Toast.makeText(ActivityTwo.this, "Data saved in SharedPreferences", Toast.LENGTH_SHORT).show();
            }
        });

        btnRsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                txtPhone.setText(prefs.getString(MainActivity.PHONE, "N/A"));
                txtMessage.setText(prefs.getString(MainActivity.MESSAGE, "N/A"));
            }
        });

        btnRIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fis = openFileInput(FILE_NAME);
                    DataInputStream dis = new DataInputStream(fis);
                    txtPhone.setText(dis.readUTF());
                    txtMessage.setText(dis.readUTF());
                    dis.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(ActivityTwo.this, "Couldn't locate the file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(ActivityTwo.this, "Couldn't read the file", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnWIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeUTF(txtPhone.getText().toString());
                    dos.writeUTF(txtMessage.getText().toString());
                    dos.close();
                    fos.close();
                    txtPhone.setText("");
                    txtMessage.setText("");
                    Toast.makeText(ActivityTwo.this, "Data saved to file", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(ActivityTwo.this, "Couldn't create a file", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(ActivityTwo.this, "Couldn't write to a file", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // SQL Write Button
        btnSqlW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtPhone.getText().toString();
                String message = txtMessage.getText().toString();
                long id = dbAdapter.insertSMS(phone, message);
                if (id > 0) {
                    Toast.makeText(ActivityTwo.this, "Data saved in database", Toast.LENGTH_SHORT).show();
                    txtMessage.setText("");
                } else {
                    Toast.makeText(ActivityTwo.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // SQL Read Button
        btnSqlR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = txtPhone.getText().toString();
                String message = dbAdapter.getMessageByPhone(phone);
                if (message != null) {
                    txtMessage.setText(message);
                } else {
                    txtMessage.setText("No message found for this phone number.");
                }
            }
        });

    }

    public class DataBaseAdapter {
        private DataBaseHelper dbHelper;

        public DataBaseAdapter(Context context) {
            dbHelper = new DataBaseHelper(context);
        }

        public long insertSMS(String phone, String message) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataBaseHelper.PHONE, phone);
            contentValues.put(DataBaseHelper.MSG, message);
            return db.insert(DataBaseHelper.SMS_TABLE_NAME, null, contentValues);
        }

        public String getMessageByPhone(String phone) {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query(
                    DataBaseHelper.SMS_TABLE_NAME,
                    new String[]{DataBaseHelper.MSG},
                    DataBaseHelper.PHONE + " = ?",
                    new String[]{phone},
                    null, null, null
            );

            if (cursor != null && cursor.moveToFirst()) {
                String message = cursor.getString(0);
                cursor.close();
                return message;
            }
            return null;
        }

        private class DataBaseHelper extends SQLiteOpenHelper {
            private static final int DATABASE_VERSION = 1;
            private static final String DATABASE_NAME = "sms_db.db";
            private static final String SMS_TABLE_NAME = "SMS";
            private static final String UID = "_id";
            private static final String PHONE = "PHONE";
            private static final String MSG = "MSG";

            private static final String CREATE_SMS_TABLE = "CREATE TABLE " + SMS_TABLE_NAME + " (" +
                    UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PHONE + " TEXT, " +
                    MSG + " TEXT);";

            public DataBaseHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_SMS_TABLE);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + SMS_TABLE_NAME);
                onCreate(db);
            }
        }
    }
}
