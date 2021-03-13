package edu.escuelaing.arep.awsDocker1.app.Service;

import com.squareup.okhttp.*;


import java.io.IOException;

public class RequestLog {
    // private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public String getData(){
        Request request = new Request.Builder()
                .url("http://localhost:4567/datastore")
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

    public void senData(String data){
        RequestBody requestBody = RequestBody.create(null, data);
        Request request = new Request.Builder()
                .url("http://localhost:4567/add")
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
