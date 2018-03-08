package com.example.justinkhull.csci499_lab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            myMethod("https://jsonplaceholder.typicode.com/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String myMethod (String myString) throws IOException {


        URL myUrl = new URL(myString);
        URLConnection myConnection = myUrl.openConnection();

        //InputStreamReader isr = new InputStreamReader(new BufferedReader());
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String newString = br.readLine();
        InputStreamReader isr = new InputStreamReader((myConnection.getInputStream()));
        BufferedReader br = new BufferedReader(isr);
        String newString = br.readLine();

        Log.i("String", "HERE");

        Log.i("String", newString);
        return myString;
    }
}
