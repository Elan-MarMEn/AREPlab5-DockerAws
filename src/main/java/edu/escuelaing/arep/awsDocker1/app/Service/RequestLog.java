package edu.escuelaing.arep.awsDocker1.app.Service;

import com.squareup.okhttp.*;


import java.io.IOException;

public class RequestLog {
    // private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public String getData(String subIp){
        Request request = new Request.Builder()
                .url("http://"+ subIp +":34000/datastore")
                .get()
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        String temp ="";
        try {
            Response response = httpClient.newCall(request).execute();
            temp = response.body().string();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public void senData(String data,String subIp){
        RequestBody requestBody = RequestBody.create(null, data);
        Request request = new Request.Builder()
                .url("http://"+ subIp +":34000/add")
                .post(requestBody)
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        String temp ="";
        try {
            Response response = httpClient.newCall(request).execute();
            temp = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
