//package com.amangarg.recrotask2.service;
//
//
//import android.util.Log;
//
//
//import org.json.JSONObject;
//
//import java.io.DataOutputStream;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Scanner;
//
//public class PostRequest {
//
//    private postResponseInterface responseInterface;
//
//    public PostRequest(String url, String params,String sessionId){
//        Runnable r = new PostThread(url,params,sessionId);
//        new Thread(r).start();
//    }
//
//    public void setResponseInterface(postResponseInterface responseInterface) {
//        this.responseInterface = responseInterface;
//    }
//
//    public class PostThread implements Runnable {
//
//        private URL url;
//        private String input;
//        private Cryptographic crypto;
//        private String cipherText;
//
//        public PostThread(String url, String params,String sessionId){
//            try {
//                this.url = new URL(url);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            this.input = params;
//            long encryption_init_time = System.currentTimeMillis();
//            this.crypto = new Cryptographic();
//            crypto.setSessionId(sessionId);
//
//            long encryption_init_end_time = System.currentTimeMillis();
//            Log.e("RSA DEMO", "Initialization Time Difference: " + String.valueOf(encryption_init_end_time - encryption_init_time));
//            long time_before_encrypting_text = System.currentTimeMillis();
//            this.cipherText = crypto.encryptData(input);
//            long time_after_encrypting_text = System.currentTimeMillis();
//            Log.e("RSA DEMO", "Encryption Time Difference: " + String.valueOf(time_after_encrypting_text - time_before_encrypting_text));
//            Log.e("Cipher text", cipherText);
//        }
//
//        @Override
//        public void run() {
//            try {
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//                conn.setRequestProperty("Accept", "application/json");
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//
//                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//                os.writeBytes(cipherText);
////                os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
////                JSONObject jsonObject = new JSONObject();
////                jsonObject.put("op","aes");
////                jsonObject.put("v",cipherText);
////                os.writeBytes(jsonObject.toString());
//
//                os.flush();
//                os.close();
//
//                Log.e("STATUS", String.valueOf(conn.getResponseCode()));
//                Log.e("MSG", conn.getResponseMessage());
//                InputStream input = conn.getInputStream();
//                Scanner scanner = new Scanner(input);
//                StringBuffer output = new StringBuffer();
//                while (scanner.hasNext()) {
//                    output.append(scanner.nextLine());
//                }
//                scanner.close();
//
//                Log.e("Data",output.toString());
//                Log.e("Data Length",output.toString().length()+"");
//                long time_before_decrypting_text = System.currentTimeMillis();
//                Log.e("Data Decrypt",crypto.decryptData(output.toString()));
//                long time_after_decrypting_text = System.currentTimeMillis();
//                Log.e("RSA DEMO", "Decryption Time Difference: " + String.valueOf(time_after_decrypting_text - time_before_decrypting_text));
//                String response = crypto.decryptData(output.toString());
//                Log.e("respone len",response.length()+"");
//                conn.disconnect();
//                if(response!=null){
//                    responseInterface.onResponseReceived(response, String.valueOf(url));
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//}