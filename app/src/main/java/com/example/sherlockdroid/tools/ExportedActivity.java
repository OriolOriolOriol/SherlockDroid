package com.example.sherlockdroid.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sherlockdroid.R;

import org.w3c.dom.Text;


public class ExportedActivity extends Activity {
    public static final int PICK_REQUEST = 1;  // codice identificativo dell activity chiamata
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String PACKAGE = getIntent().getStringExtra("Package");
        String Activity = getIntent().getStringExtra("Activity");
        Intent pickSecretIntent= new Intent();
        pickSecretIntent.setComponent(new ComponentName(PACKAGE,Activity));
        //startActivity(pickSecretIntent); //TODO SecretActivity
        startActivityForResult(pickSecretIntent, PICK_REQUEST); //TODO LeakyActivity
        setContentView(R.layout.exported);

    }

    //Bisogna costruire un metodo override che permette di gestire il dato che ci arriva
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_REQUEST) {
            if (resultCode == 2) {
                String secret = data.getStringExtra("SECRET");
                Log.v("SECRET",secret);
                //Riporto a schermo il valore...
                TextView testo_result= (TextView) findViewById(R.id.resultActivity);
                testo_result.setText(secret);

            }
        }
    }

}
