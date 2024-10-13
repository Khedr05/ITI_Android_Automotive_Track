package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Cake;
import com.example.recyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final Context context;
    private List<Cake> values;
    private static final String TAG = "RecyclerView";

    // Constructor
    public MyAdapter(Context _context, List<Cake> myDataset) {
        this.context = _context;
        this.values = myDataset;
    }

    // ViewHolder inner class
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public TextView txtDescription;
        public ImageView imageView;
        public android.widget.LinearLayout LinearLayout;
        public View layout;

        // ViewHolder constructor
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtTitle = v.findViewById(R.id.titleTxtView);
            txtDescription = v.findViewById(R.id.descTxtView);
            imageView = v.findViewById(R.id.imgView);
            LinearLayout = v.findViewById(R.id.row);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.cake_row, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtTitle.setText(values.get(position).getTitle());
        holder.txtDescription.setText(values.get(position).getDescription());
        holder.imageView.setImageResource(values.get(position).getImage());
        holder.LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,values.get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        Log.i(TAG, "***** onBindViewHolder **************");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}
