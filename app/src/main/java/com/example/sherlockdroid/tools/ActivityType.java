package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sherlockdroid.MainActivity;
import com.example.sherlockdroid.R;

import static com.example.sherlockdroid.config.Config.ActivityExported;
import static com.example.sherlockdroid.config.Config.PACKAGE;

public class ActivityType  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitychoose);
        Button webViewButton= (Button) findViewById(R.id.Activity1);
        Button classicActivity= (Button) findViewById(R.id.Activity2);

        webViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collegamento = new Intent(ActivityType.this, com.example.sherlockdroid.tools.WebViewExported.class);
                collegamento.putExtra("Package", PACKAGE);
                collegamento.putExtra("Activity",ActivityExported);
                startActivity(collegamento);
            }
        });

        classicActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collegamento = new Intent(ActivityType.this, com.example.sherlockdroid.tools.ExportedActivity.class);
                collegamento.putExtra("Package", PACKAGE);
                collegamento.putExtra("Activity",ActivityExported);
                startActivity(collegamento);
            }
        });


    }
}
