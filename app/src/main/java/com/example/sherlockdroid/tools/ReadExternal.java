package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sherlockdroid.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadExternal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_external);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String FileContainer = "FileContainer";
                EditText mFileName = (EditText) findViewById(R.id.ReadFileName);
                String filename = mFileName.getText().toString();
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    String pathToFile = "Android/data/com.example.prova/files/" + FileContainer + "/" + filename;
                    File dir = Environment.getExternalStorageDirectory();
                    File MyFile = new File(dir, pathToFile);
                    BufferedReader br = null;
                    TextView mFileLocation = (TextView) findViewById(R.id.results);
                    mFileLocation.setText("");
                    try {
                        br = new BufferedReader(new FileReader(MyFile));
                        String line;
                        while ((line = br.readLine()) != null) {
                            mFileLocation.setText(line);
                        }
                        br.close();
                    } catch (IOException e) {
                        mFileLocation.setText(e.toString());
                    }
                }
            }
        });
    }

}
