package com.spizer.mizer2.utilityclasses;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Files extends AppCompatActivity{

    String FILENAME1 = "RecentSessions";
    String RecentSessions;
    FileOutputStream RS;

    File files = new File(getFilesDir(), FILENAME1);

    /* makes a TempFIle for saving the users recent sessions */
    public File getTempFIle(Context context, String url) {
        File file = null;
        try {
            String filename = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(filename, null, context.getFilesDir());
        } catch (IOException e) {
            // Error while creating file
        }
        return file;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

}
