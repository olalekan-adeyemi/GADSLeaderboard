package com.lakeside.gadsleaderboard.ui.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lakeside.gadsleaderboard.ui.main.LeaderBoardActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, LeaderBoardActivity.class));
        finish();
    }
}