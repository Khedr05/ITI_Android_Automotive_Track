package com.example.productcardretrofitglide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final Context context;
    private List<Product> values;
    private static final String TAG = "RecyclerView";

    // Constructor
    public MyAdapter(Context _context, List<Product> myDataset) {
        this.context = _context;
        this.values = myDataset;
    }

    // ViewHolder inner class
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView titleTxtView;
        public TextView descTxtView;
        public TextView priceTxtView;
        public RatingBar ratingBar;
        public ConstraintLayout constraintLayout;
        public View layout;

        // ViewHolder constructor
        public ViewHolder(View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.img);
            titleTxtView = v.findViewById(R.id.titleTxtView);
            descTxtView = v.findViewById(R.id.descTxtView);
            priceTxtView = v.findViewById(R.id.priceTxtView);
            ratingBar = v.findViewById(R.id.ratingBar);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.product_card, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context).load(values.get(position).getThumbnail())
                        .apply(new RequestOptions().override(200,200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                        .into(holder.img);
        holder.titleTxtView.setText(values.get(position).getTitle());
        holder.descTxtView.setText(values.get(position).getDescription());
        holder.priceTxtView.setText(String.valueOf(values.get(position).getPrice()));
        holder.ratingBar.setRating((float) values.get(position).getRating());


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
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
