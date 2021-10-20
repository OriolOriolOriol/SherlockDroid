package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ExportedContent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String PACKAGE = getIntent().getStringExtra("Package");
        String ContentURI= getIntent().getStringExtra("ContentURI");
        String ContentProvider= getIntent().getStringExtra("ContentProvider");
        Log.v("LOGGG1",PACKAGE);
        Log.v("LOGGGG2",ContentURI);
        Log.v("LOGGGG3",ContentProvider);




    }
}
