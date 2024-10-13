package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Cake> input;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        input = Arrays.asList(new Cake("Cake1" , "Cake1 Desc",R.drawable.one),
                new Cake("Cake2" , "Cake2 Desc",R.drawable.two),
                new Cake("Cake3" , "Cake3 Desc",R.drawable.three),
                new Cake("Cake4" , "Cake4 Desc",R.drawable.four),
                new Cake("Cake5" , "Cake5 Desc",R.drawable.five),
                new Cake("Cake6" , "Cake6 Desc",R.drawable.six),
                new Cake("Cake7" , "Cake7 Desc",R.drawable.seven));
        
        mAdapter = new MyAdapter(this,input);
        recyclerView.setAdapter(mAdapter);

    }
}