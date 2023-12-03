package com.example.assignment3_quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {


    TextView questionTextview;
    View fragmentContainer;
    // New code
    private MyApp myApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
//new code
        questionTextview = view.findViewById(R.id.text_View);
        myApp = (MyApp) requireActivity().getApplication() ;

        updateQuestion();
        return view;
    }
    public void updateQuestion() {
        // Update question text
        questionTextview.setText(myApp.getCurrentQuestion());
    }
}