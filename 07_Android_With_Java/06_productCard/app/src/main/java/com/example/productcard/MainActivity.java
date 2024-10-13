package com.example.productcard;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int UPDATE_UI = 1;
    private Vector<Product> productList = new Vector<Product>();;
    private Handler uiHandler;
    private int currentIndex = 0;

    private ImageView img;
    private ImageButton leftBtn;
    private ImageButton rightBtn;
    private TextView titleTxtView;
    private TextView descTxtView;
    private TextView brandTxtView;
    private TextView priceTxtView;
    private RatingBar ratingBar;

    public void disableSSLCertificateChecking() {
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disableSSLCertificateChecking();
        img = findViewById(R.id.img);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);
        titleTxtView = findViewById(R.id.titleTxtView);
        descTxtView = findViewById(R.id.descTxtView);
        //brandTxtView = findViewById(R.id.brandTxtView);
        priceTxtView = findViewById(R.id.priceTxtView);
        ratingBar = findViewById(R.id.ratingBar);


        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % productList.size();
                Message msg = uiHandler.obtainMessage(UPDATE_UI, productList.get(currentIndex));
                uiHandler.sendMessage(msg);
            }
        });

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex - 1 + productList.size()) % productList.size();
                Message msg = uiHandler.obtainMessage(UPDATE_UI, productList.get(currentIndex));
                uiHandler.sendMessage(msg);
            }
        });



        uiHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == UPDATE_UI) {
                    Product product = (Product) msg.obj;
                    if (product != null) {
                        titleTxtView.setText(product.getTitle());
                        descTxtView.setText(product.getDescription());
                       // brandTxtView.setText(product.getBrand());
                        priceTxtView.setText(String.valueOf(product.getPrice()));
                        ratingBar.setRating((float) product.getRating());
                        img.setImageBitmap(product.getImage());
                    } else {
                        Toast.makeText(getApplicationContext(), "No products found", Toast.LENGTH_LONG).show();
                    }
                }
            }
        };

        new Thread() {
            public void run() {
                HttpHandler sh = new HttpHandler();
                // Making a request to URL and getting response
                String url = "https://dummyjson.com/products";
                String jsonStr = sh.makeServiceCall(url);

                Log.e(TAG, "Response from url: " + jsonStr);
                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);

                        // Getting JSON Array node
                        JSONArray products = jsonObj.getJSONArray("products");
                        for(int i=0;i<products.length();i++) {
                            JSONObject p = products.getJSONObject(i);
                            Product tmpProduct = new Product();
                            tmpProduct.setTitle(p.getString("title"));
                            tmpProduct.setDescription(p.getString("description"));
                            tmpProduct.setPrice(p.getDouble("price"));
                            tmpProduct.setRating(p.getDouble("rating"));
                            tmpProduct.setThumbnail(p.getString("thumbnail"));
                            //tmpProduct.setBrand(p.getString("brand"));
                            tmpProduct.getBitmapFromURL(tmpProduct.getThumbnail());
                            productList.add(tmpProduct);
                        }

                        Message msg = uiHandler.obtainMessage(UPDATE_UI, productList.get(0));
                        uiHandler.sendMessage(msg);

                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        Message msg = uiHandler.obtainMessage(UPDATE_UI, (Product) null);
                        uiHandler.sendMessage(msg);
                        e.printStackTrace();
                    }
                } else {
                    Log.e(TAG, "Couldn't get json from server.");
                    Message msg = uiHandler.obtainMessage(UPDATE_UI, (Product) null);
                    uiHandler.sendMessage(msg);
                }
            }
        }.start();
    }
}
