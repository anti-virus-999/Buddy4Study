package com.example.buddy4study;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.Buffer;

public class BackgroundTask extends AsyncTask<String,String,String> {
    Context context;
    BackgroundTask(Context ctx){
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String username = strings[0];
        String password = strings[1];
        String request_url = "http://www.unlockppt.epizy.com/Bhavin/index.php";
        try{
            URL   url = new URL(request_url);
            try{
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                String cookie = "__test=a81b0dbdc5ae8689a93b9be133d30b26;expires=Friday, January 1, 2038 at 5:25:55 AM;path=/";
                httpURLConnection.setRequestProperty("Cookie",cookie);
                OutputStream outputStream =  httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                String insert_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(insert_data);
                bufferedWriter.flush();
                bufferedWriter.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader  inputStreamReader = new InputStreamReader(inputStream,"ISO-8859-1");
                BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);
                String result = "";
                String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((line=bufferedReader.readLine())!=null){
                        stringBuilder.append(line).append("\n");
                }
                result = stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  result;


            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();


    }
}
