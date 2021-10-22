package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sherlockdroid.R;

import static com.example.sherlockdroid.config.Config.PACKAGE;
import static com.example.sherlockdroid.config.Config.ProviderExported1;
import static com.example.sherlockdroid.config.Config.ProviderExported2;

public class ContentURI extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        Button pathButton= (Button) findViewById(R.id.ContentURi1);
        Button DBButton= (Button) findViewById(R.id.ContentURi2);

        pathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collegamento = new Intent(ContentURI.this, com.example.sherlockdroid.tools.ExportedContentPathTraversal.class);
                collegamento.putExtra("Package", PACKAGE);
                //collegamento.putExtra("ContentURI", ProviderExported1);
                //collegamento.putExtra("ContentProvider",ProviderExported2);
                startActivity(collegamento);
            }
        });

        DBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent collegamento = new Intent(ContentURI.this, com.example.sherlockdroid.tools.ExportedContent.class);
                collegamento.putExtra("Package", PACKAGE);
                collegamento.putExtra("ContentURI", ProviderExported1);
                collegamento.putExtra("ContentProvider",ProviderExported2);
                startActivity(collegamento);
            }
        });

    }
}
