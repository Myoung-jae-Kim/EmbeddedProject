package com.example.kimmyoungjae.embeddedproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private SQLiteDatabase userDB;
    public static final String CONTENT_NAME = "name";
    public static final String CONTENT_ID = "id";
    public static final String CONTENT_PASSWORD = "password";
    Cursor uCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FeedReaderDbHelper userDbHelper = new FeedReaderDbHelper(this);
        userDB = userDbHelper.getWritableDatabase();
        userDbHelper.onCreate(userDB);
    }

    public void InsertDB(View view) {
        EditText name = (EditText) findViewById(R.id.inputname);
        EditText id = (EditText) findViewById(R.id.inputid);
        EditText pwd = (EditText) findViewById(R.id.inputpwd);

        ContentValues v = new ContentValues();
        v.put(CONTENT_NAME, name.getText().toString());
        userDB.insert("userdb", null, v);
        v.put(CONTENT_ID, id.getText().toString());
        userDB.insert("userdb", null, v);
        v.put(CONTENT_PASSWORD, pwd.getText().toString());
        userDB.insert("userdb", null, v);

        Toast.makeText(getApplicationContext(), "Insert ok", Toast.LENGTH_LONG).show();
    }
}
