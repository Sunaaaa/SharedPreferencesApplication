package com.example.savepreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        Button b = (Button)findViewById(R.id.btn);
        final EditText id = (EditText)findViewById(R.id.id);
        final EditText pw = (EditText)findViewById(R.id.ipw);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = id.getText().toString();
                String userpw = pw.getText().toString();

                SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("id", userid);
                editor.putString("pw", userpw);
                editor.commit();

                Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.example.savepreferencesapplication","com.example.savepreferencesapplication.MainActivity");
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });
    }
}
