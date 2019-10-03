package com.example.savepreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button remove_btn = (Button)findViewById(R.id.remove_btn);
        TextView tv = (TextView)findViewById(R.id.tv);
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        tv.setText(preferences.getString("id", "NO"));

        // 객체 가져오기
        String json = preferences.getString("vo", "");
        Gson gson = new Gson();
        UserVO vo = gson.fromJson(json, UserVO.class);

        Toast.makeText(getApplicationContext(), preferences.getString("pw", "NO"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), vo.getId() + vo.getPw(), Toast.LENGTH_SHORT).show();
    }
}
