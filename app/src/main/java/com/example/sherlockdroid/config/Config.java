package com.example.sherlockdroid.config;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    public static final String PACKAGE = "jakhar.aseem.diva";
    //===========================================================================================================
    public static final String ActivityExported="jakhar.aseem.diva.LogActivity";
    //===========================================================================================================
    public static final String ReceiverExported="org.owasp.goatdroid.fourgoats.broadcastreceivers.SendSMSNowReceiver";
    public static final String ReceiverExportedACTION="org.owasp.goatdroid.fourgoats.SOCIAL_SMS";
    //===========================================================================================================
    public static final String ServiceExported="com.elearnsecurity.sillyservice.SillyService";
    //===========================================================================================================
    public static final String ProviderExported1="com.elearnsecurity.injectme.provider.CredentialProvider/credentials"; //qui inserisci il content URI
    public static final String ProviderExported2="com.elearnsecurity.injectme.CredentialProvider"; //qui il path del nome della classe in cui viene usato il content URI
    //===========================================================================================================
    public static final String ProviderExportedPath1="content://"+ PACKAGE+"/../../../../../../etc/hosts";
    public static final String ProviderExportedPath2="com.els.filebrowser.accessfile";







    //========================================================================================================================
    //========================================================================================================================
    //========================================================================================================================
    //========================================================================================================================

    /* Checks if external storage is available for read and write */
    public  boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public  boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public void appendLog(String text)
    {
        File logFile = new File("sdcard/log.file");
        if (!logFile.exists())
        {
            try
            {
                logFile.createNewFile();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try
        {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    public void log() throws IOException {

        if (configurazione.isExternalStorageWritable()) {
            TextView testo_result= (TextView) findViewById(R.id.resultService);
            testo_result.setText("OK");
            File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()+ "/Prova/");
            boolean prova=dir.exists();
            Log.v("ESISTE!!!", String.valueOf(prova));
            //if (!dir.exists()) {
            //    dir.mkdirs();
            //}
            Log.v("PATHHH",dir.toString());
            //File appDirectory = new File( Environment.getExternalStorageDirectory() + "/MyPersonalAppFolder" );
            //File logDirectory = new File( appDirectory + "/logs" );
            File logFile = new File( dir , "logcat_" + System.currentTimeMillis() + ".txt" );
            logFile.createNewFile();
            Process process = Runtime.getRuntime().exec("logcat  --pid=7487 -f " + logFile);
            // create app folder
            /*
            if ( !appDirectory.exists() ) {
                appDirectory.mkdir();
            }
            // create log folder
            if ( !logDirectory.exists() ) {
                logDirectory.mkdir();
            }

            try {
                Process process = Runtime.getRuntime().exec("logcat  --pid=7487 -f " + logFile);
            } catch ( IOException e ) {
                e.printStackTrace();
            }



        } else if (configurazione.isExternalStorageReadable()) {
            TextView testo_result= (TextView) findViewById(R.id.resultService);
            testo_result.setText("Solo lettura");
        } else {
            TextView testo_result= (TextView) findViewById(R.id.resultService);
            testo_result.setText("Non ?? possibile fare nulla");
        }
    }
     */


      /*
        try {
            Process process = Runtime.getRuntime().exec("logcat --pid=7487");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            Log.v("LOGG",log.toString());
            //TextView tv = (TextView)findViewById(R.id.resultService);
            //tv.setText(log.toString());
        }
        catch (IOException e) {}
        */



        /*
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("logcat  --pid=7487");

            Log.v("LOGG",process.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */




}
