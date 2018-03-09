package com.example.justinkhull.csci499_lab04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by justinkhull on 3/8/18.
 */

public class AsyncTaskClass extends AsyncTask<String, Void, String> {
    private TextView textview;
    //private String myString = "https://jsonplaceholder.typicode.com/users";
    public AsyncTaskClass(TextView textview) {
        this.textview = textview;

    }
    @Override
    protected String doInBackground (String... myString){
        String aString = "";
        try {
            aString = myMethod(myString[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aString;
    }

    protected String myMethod (String myString) throws IOException {


        URL myUrl = new URL(myString);
        URLConnection myConnection = myUrl.openConnection();

        InputStreamReader isr = new InputStreamReader((myConnection.getInputStream()));
        BufferedReader br = new BufferedReader(isr);


        String newString = br.readLine();

        int i = 0;
        while (i < 20) {
            newString += br.readLine();
            i++;
        }

        Log.i("String", "HERE");

        Log.i("String", newString);
        return newString;
    }

    @Override
    protected void onPostExecute(String newString) {
        textview.setText(newString.substring(10, 23));
        Log.i("JSON", newString);
    }
}
