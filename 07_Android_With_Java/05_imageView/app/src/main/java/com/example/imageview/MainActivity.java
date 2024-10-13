package com.example.imageview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Button downBtn;
    ImageView img;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downBtn = findViewById(R.id.downloadBtn);
        img = findViewById(R.id.imageView);
        url = findViewById(R.id.urlTxt);

        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadTask task = new DownloadTask();
                task.execute(url.getText().toString());
            }
        });
    }

    private Bitmap download(String url) throws IOException {
        URL imgUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) imgUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int response = connection.getResponseCode();
        InputStream is = connection.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }

    class DownloadTask extends AsyncTask<String,Void,Bitmap> {

        protected  Bitmap doInBackground(String... urls){
            Bitmap result = null ;
            try{
                result = download(urls[0]);
                publishProgress();
            } catch (IOException e){
                e.printStackTrace();
            }
            return result;
        }

        protected  void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }

    }

}