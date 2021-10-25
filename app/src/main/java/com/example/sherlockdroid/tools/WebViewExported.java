package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class WebViewExported extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String PACKAGE = getIntent().getStringExtra("Package");
        String Activity = getIntent().getStringExtra("Activity");
        Log.v("LOGGG1",PACKAGE);
        Log.v("LOGGGG2",Activity);
        Log.v("PATH EXTERNAL", Environment.getExternalStorageDirectory().toString());
        try {
            Intent start = new Intent();
            start.setClassName(PACKAGE, Activity);
            start.putExtra("uname", "attacker");//parametro unname viene cambiato in questo modo viene fatto un attacco XSS via WebView
            startActivity(start);
            Toast.makeText(this, "WebView Attacking done", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "An error is occurs " + e, Toast.LENGTH_SHORT).show();
        }

    }
}
