package com.sumit.a8080.agriculture;

/**
 * Created by DELL on 28-01-2017.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonRequest {
    private String json_url;
    private String JSON_STRING;

    public JsonRequest(String url, String data) {
        json_url = url;
        JSON_STRING = data;
    }

    protected String jsonRequest() {
        try {
            URL url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while ((JSON_STRING = br.readLine()) != null) {
                sb.append(JSON_STRING).append("\n");
            }
            Log.e("Json : ", sb.toString());
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
