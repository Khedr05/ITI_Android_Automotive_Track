package com.example.fregmentcounter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {

    private static final String COUNTER_STATE_KEY = "counterState";
    private TextView countTextView;
    private int counter = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_STATE_KEY, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        countTextView = view.findViewById(R.id.countTxtView);
        countTextView.setText("Button clicked " + counter + " times");
        return view;
    }

    public void updateCount(int count) {
        countTextView.setText("Button clicked " + count + " times");
        counter = count;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_STATE_KEY, counter);
    }
}