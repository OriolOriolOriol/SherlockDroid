package com.example.sherlockdroid;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.sherlockdroid.config.Config.ActivityExported;
import static com.example.sherlockdroid.config.Config.PACKAGE;
import static com.example.sherlockdroid.config.Config.ProviderExported1;
import static com.example.sherlockdroid.config.Config.ProviderExported2;
import static com.example.sherlockdroid.config.Config.ReceiverExported;
import static com.example.sherlockdroid.config.Config.ReceiverExportedACTION;
import static com.example.sherlockdroid.config.Config.ServiceExported;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if(isProviderishere()){
                setContentView(R.layout.activity_main);
                //Gli oggetti che inizializzi sempre dopo la creazione del contentView

                /*1- EXPORTED ACTIVITY*/
                Button exportedActivity = (Button) findViewById(R.id.ExportedActivity);
                exportedActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent collegamento = new Intent(MainActivity.this, com.example.sherlockdroid.tools.ExportedActivity.class);
                        collegamento.putExtra("Package", PACKAGE);
                        collegamento.putExtra("Activity",ActivityExported);
                        startActivity(collegamento);
                    }
                });//Close action button exportedActivity
                //=======================================================================================================================================================

                /*2- EXPORTED RECEIVER*/
                Button exportedReceiver=(Button) findViewById(R.id.ExportedReceiver);
                exportedReceiver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent collegamento = new Intent(MainActivity.this, com.example.sherlockdroid.tools.ExportedReceiver.class);
                        collegamento.putExtra("Package", PACKAGE);
                        collegamento.putExtra("Receiver",ReceiverExported);
                        collegamento.putExtra("ReceiverACTION",ReceiverExportedACTION);
                        startActivity(collegamento);
                    }
                });
                //=======================================================================================================================================================

                /*3- EXPORTED SERVICE*/
                Button exportedServices= (Button) findViewById(R.id.ExportedService);
                exportedServices.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent collegamento = new Intent(MainActivity.this, com.example.sherlockdroid.tools.ExportedService.class);
                        collegamento.putExtra("Package", PACKAGE);
                        collegamento.putExtra("Service", ServiceExported);
                        startActivity(collegamento);
                    }
                });

                /*4- EXPORTED CONTENT PROVIDER (CONTENT URI)*/
                Button exportedContent=(Button) findViewById(R.id.ContentURI);
                exportedContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent collegamento = new Intent(MainActivity.this, com.example.sherlockdroid.tools.ContentURI.class);
                        //collegamento.putExtra("Package", PACKAGE);
                        //collegamento.putExtra("ContentURI", ProviderExported1);
                        //collegamento.putExtra("ContentProvider",ProviderExported2);
                        startActivity(collegamento);
                    }
                });

            }else{
                Log.v("NON ESISTE", "IL PACKAGE O COMPONENTE NON ESISTE");
                //Fai altro
            }
        } catch (PackageManager.NameNotFoundException e) {
            //Log.v("NON ESISTE", "IL PACKAGE O ACTIVITY NON ESISTE2");
            Toast error = Toast.makeText(this,"Package " + PACKAGE  + " not found", Toast.LENGTH_SHORT);
            error.show();
        }



    }//Close method onCreate







    private  boolean isPackageInstalled() {
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getPackageInfo(PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
    //========================================================================================================================
    //========================================================================================================================
    public boolean isActivityishere() throws PackageManager.NameNotFoundException {
        PackageManager pManager = getPackageManager();
        if(isPackageInstalled()){
            ActivityInfo[] list = pManager.getPackageInfo(PACKAGE, PackageManager.GET_ACTIVITIES).activities;
            for (ActivityInfo activityInfo : list) {
                if(activityInfo.name.equals(ActivityExported)) {
                    Toast info = Toast.makeText(this,activityInfo.name + " found" , Toast.LENGTH_SHORT);
                    info.show();
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }//Close method isActivityishere
    //========================================================================================================================
    //========================================================================================================================
    public boolean isServiceishere() throws PackageManager.NameNotFoundException {
        PackageManager pManager = getPackageManager();
        if(isPackageInstalled()){
            ServiceInfo[] list = pManager.getPackageInfo(PACKAGE, PackageManager.GET_SERVICES).services;
            for (ServiceInfo serviceInfo : list) {
                if(serviceInfo.name.equals(ServiceExported)) {
                    Toast info = Toast.makeText(this,serviceInfo.name + " found" , Toast.LENGTH_SHORT);
                    info.show();
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }//Close method isService
    //========================================================================================================================
    //========================================================================================================================
    public boolean isProviderishere() throws PackageManager.NameNotFoundException {
        PackageManager pManager = getPackageManager();
        if(isPackageInstalled()){
            ProviderInfo[] list = pManager.getPackageInfo(PACKAGE, PackageManager.GET_PROVIDERS).providers;
            for (ProviderInfo providerInfo : list) {
                //Log.v("PROVIDERS",providerInfo.name);
                if(providerInfo.name.equals(ProviderExported2)) {
                    Toast info = Toast.makeText(this,providerInfo.name + " found" , Toast.LENGTH_SHORT);
                    info.show();
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }//Close method isReceiver
    //========================================================================================================================
    //========================================================================================================================
    public boolean isReceiverishere() throws PackageManager.NameNotFoundException {
        PackageManager pManager = getPackageManager();
        if(isPackageInstalled()){
            ActivityInfo[] list = pManager.getPackageInfo(PACKAGE, PackageManager.GET_RECEIVERS).receivers;
            for (ActivityInfo activityInfo : list) {
                if(activityInfo.name.equals(ReceiverExported)) {
                    Toast info = Toast.makeText(this,activityInfo.name + " found" , Toast.LENGTH_SHORT);
                    info.show();
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }//Close method isReceiver
}