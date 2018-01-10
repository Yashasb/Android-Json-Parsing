package com.example.ganesha.udacity_interview_assignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ganesha on 1/9/2018.
 */

public class ImageLoadAsyncTask extends AsyncTask<Void,Void,Bitmap> {

    String url;

    ImageView imageView;

    public ImageLoadAsyncTask(String url, ImageView imageView) {
        this.url = url;
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        try {
            URL myurl=new URL(url);
            try {
                HttpURLConnection httpURLConnection=(HttpURLConnection)myurl.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream input = httpURLConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                return bitmap;

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
