package com.example.productcardrecyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Product {
    private String title;
    private String description;
    private double price;
    private double rating;
    private String thumbnail;
    private String brand;
    private Bitmap image;

    // Getter and Setter methods
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Bitmap getImage(){return image; }

    public void getBitmapFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            this.image = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
