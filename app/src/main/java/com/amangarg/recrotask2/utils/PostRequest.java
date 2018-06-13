package com.amangarg.recrotask2.utils;

import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;


public class PostRequest {

    private postResponseInterface responseInterface;

    public PostRequest(String url, String params) {
        Runnable r = new PostThread(url, params);
        new Thread(r).start();
    }

    public void setResponseInterface(postResponseInterface responseInterface) {
        this.responseInterface = responseInterface;
    }

    public class PostThread implements Runnable {

        private URL url;
        private String input;
        private String body;

        public PostThread(String url, String jsonString) {
            try {
                this.url = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            this.body = jsonString;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);

                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(body);

                os.flush();
                os.close();

                Log.e("STATUS", String.valueOf(conn.getResponseCode()));
                Log.e("MSG", conn.getResponseMessage());
                InputStream input = conn.getInputStream();
                Scanner scanner = new Scanner(input);
                StringBuffer output = new StringBuffer();
                while (scanner.hasNext()) {
                    output.append(scanner.nextLine());
                }
                scanner.close();
                String response = output.toString();
//                JSONObject jsonObject = new JSONObject(response);
                conn.disconnect();
                if (response != null) {
                    responseInterface.onResponseReceived(response, String.valueOf(url),conn.getResponseCode());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}