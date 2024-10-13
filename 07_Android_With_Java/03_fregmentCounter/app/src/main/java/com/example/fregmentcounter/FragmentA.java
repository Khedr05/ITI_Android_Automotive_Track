package com.example.fregmentcounter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;

public class FragmentA extends Fragment {

    private static final String COUNTER_STATE_KEY = "counterState";
    private int counter = 0;
    private Button clickButton;
    private OnButtonClickListener listener;

    public interface OnButtonClickListener {
        void sendCount(int count);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnButtonClickListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_STATE_KEY, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        clickButton = view.findViewById(R.id.countBtn);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                listener.sendCount(counter);
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_STATE_KEY, counter);
    }
}
