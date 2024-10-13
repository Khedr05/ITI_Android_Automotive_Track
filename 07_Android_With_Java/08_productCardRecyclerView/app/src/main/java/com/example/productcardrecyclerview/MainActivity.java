package com.example.productcardrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Product> productList = new Vector<>(); 
    private MyAdapter mAdapter;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int UPDATE_UI = 1;
    private Handler uiHandler;


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

        uiHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.obj instanceof List<?>) {
                    recyclerView = findViewById(R.id.recycleView);
                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    recyclerView.setLayoutManager(layoutManager);
                    mAdapter = new MyAdapter(MainActivity.this, (List<Product>) msg.obj);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
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
                            tmpProduct.getBitmapFromURL(tmpProduct.getThumbnail());
                            productList.add(tmpProduct);
                        }

                        Message msg = uiHandler.obtainMessage(UPDATE_UI, productList);
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