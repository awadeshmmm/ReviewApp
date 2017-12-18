package com.example.awadeshkumar.reviewapp.helpers;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Jainendra Kumar on 7/2/2015.
 */
public class HttpRequest {
    static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static String GET(String stringUrl) {
        String result = "";

        try {
            URL url = new URL(stringUrl);
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String POST(String stringUrl, String message) {
        if (message == null) {
            message = "";
        }
        String result = "";
        try {
            //constants
            URL url = new URL(stringUrl);

            RequestBody body = RequestBody.create(JSON, message);
            Request request = new Request.Builder().url(url).post(body).build();

            Response response = client.newCall(request).execute();
            result = response.body().string();

        } catch (MalformedURLException e) {
            //Logger.appendErrorLog(e.getMessage() + "/" + Arrays.toString(e.getStackTrace()), "HttpPost");
        } catch (IOException e) {
            Log.d("exception", e.getMessage());
            //Logger.appendErrorLog(e.getMessage() + "/" + Arrays.toString(e.getStackTrace()), "HttpPost");
        }
        return result;
    }


}
