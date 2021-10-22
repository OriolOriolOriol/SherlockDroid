package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sherlockdroid.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExportedContentPathTraversal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_uri_file);
        String PACKAGE = getIntent().getStringExtra("Package");
        String ContentURI= getIntent().getStringExtra("ContentURI");
        String ContentProvider= getIntent().getStringExtra("ContentProvider");
        Log.v("LOGGG1",PACKAGE);
        Log.v("LOGGGG2",ContentURI);
        Log.v("LOGGGG3",ContentProvider);


        TextView mTextInput = (TextView) findViewById(R.id.editText2);
        mTextInput.setText(ContentURI);
        String userInput = mTextInput.getText().toString();
        Button readFile= (Button)findViewById(R.id.ReadFile);
        readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PathTraversalExploit(userInput);
            }
        });



    }

    private void PathTraversalExploit(String userInput){
        TextView mTextResults = (TextView) findViewById(R.id.editText1);
        mTextResults.setText("");
        if (userInput != null && userInput.length() != 0){
            Uri targURI = Uri.parse(userInput);
            InputStream content = null;
            try {
                content = getContentResolver().openInputStream(targURI);
            } catch (FileNotFoundException e1) {
                Toast.makeText(getApplicationContext(), "Could not read the content. Please check the URI is correct", Toast.LENGTH_LONG).show();
                return;
            }

            //Leggi il contenuto
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(content));
            String line1;
            try {
                while ((line1 = reader1.readLine()) != null) {
                    mTextResults.append(line1);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }else{
            Toast.makeText(getApplicationContext(), "Please check your input", Toast.LENGTH_SHORT).show();
        }
    }

}
