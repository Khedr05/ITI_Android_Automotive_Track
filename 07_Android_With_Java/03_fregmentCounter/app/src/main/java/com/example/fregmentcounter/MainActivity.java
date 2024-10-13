package com.example.fregmentcounter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentA.OnButtonClickListener {

    private static final String DYNAMIC_FRAGMENT_TAG = "dynamicFragment";
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mgr = getSupportFragmentManager();
        if(savedInstanceState == null) {
            fragmentB = new FragmentB();
            FragmentTransaction trns = mgr.beginTransaction();
            trns.add(R.id.dynamicFragment,fragmentB,DYNAMIC_FRAGMENT_TAG);
            trns.commit();
        }else{
            fragmentB = (FragmentB) mgr.findFragmentByTag(DYNAMIC_FRAGMENT_TAG);
        }

    }
    public void sendCount(int count) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.dynamicFragment);
        if (fragmentB != null) {
            fragmentB.updateCount(count);
        }
    }
}