package com.example.assignment3_quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button trueBtn, falseBtn, nextBtn;
    ProgressBar progress_Bar;
    private MyApp myApp;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frame_Layout);
        trueBtn = findViewById(R.id.true_btn);
        falseBtn = findViewById(R.id.false_btn);
        nextBtn = findViewById(R.id.next_btn);
        progress_Bar = findViewById(R.id.progress_Bar);

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Assignment 3", "Button 1 has been clicked.");
            }
        });
        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Assignment 3", "Button 2 has been clicked.");
            }
        });
        // Add or remove fragment in the Frame Layout.
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FirstFragment check_fragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.frame_Layout);
//                if (check_fragment == null) {
//                    FirstFragment tf = new FirstFragment();
//                    //tf.listener = MainActivity.this;
//                    getSupportFragmentManager().beginTransaction().add(R.id.frame_Layout, tf).commit();
//
//                } else {
//                    getSupportFragmentManager().beginTransaction().remove(check_fragment).commit();
//
//                }
                myApp.moveToNextQuestion();
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_Layout);
                if (currentFragment instanceof FirstFragment) {
                    ((FirstFragment) currentFragment).updateQuestion();
                }
            }
        });
        myApp = (MyApp) getApplication();
        FirstFragment firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_Layout, firstFragment)
                .commit();
    }
}