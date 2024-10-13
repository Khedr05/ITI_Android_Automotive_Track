package com.example.fregmentlifecycle;

import android.os.Bundle;
import android.util.Log;  // For logging
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    private static final String TAG = "FragmentA";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach called");
    }
}
