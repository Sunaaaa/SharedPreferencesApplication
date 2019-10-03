package com.example.savepreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView)findViewById(R.id.tv);
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        tv.setText(preferences.getString("id", "NO"));

        Toast.makeText(getApplicationContext(), preferences.getString("pw", "NO"), Toast.LENGTH_SHORT).show();
    }
}
