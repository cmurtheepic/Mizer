package com.spizer.mizer2.utilityclasses;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by connor on 9/30/2015.
 */
public class Files extends AppCompatActivity{

    String FILENAME1 = "RecentSessions";

    String RecentSessionDateCode = "";
    public String getRecentSessionDateCode() {
        return RecentSessionDateCode;
    }
    public void setRecentSessionDateCode(String recentSessionDateCode) {
        RecentSessionDateCode = recentSessionDateCode;
    }
    String RecentSessionArithmeticType = "";
    public String getRecentSessionArithmeticType() {
        return RecentSessionArithmeticType;
    }
    public void setRecentSessionArithmeticType(String recentSessionArithmeticType) {
        RecentSessionArithmeticType = recentSessionArithmeticType;
    }
    String RecentSessionOperationType = "";
    public String getRecentSessionOperationType() {
        return RecentSessionOperationType;
    }
    public void setRecentSessionOperationType(String recentSessionOperationType) {
        RecentSessionOperationType = recentSessionOperationType;
    }
    String RecentSessionProbNum1 = "";
    public String getRecentSessionProbNum1() {
        return RecentSessionProbNum1;
    }
    public void setRecentSessionProbNum1(String recentSessionProbNum1) {
        RecentSessionProbNum1 = recentSessionProbNum1;
    }
    String RecentSessionProbNum2 = "";
    public String getRecentSessionProbNum2() {
        return RecentSessionProbNum2;
    }
    public void setRecentSessionProbNum2(String recentSessionProbNum2) {
        RecentSessionProbNum2 = recentSessionProbNum2;
    }
    String RecentSessionScore = "";
    public String getRecentSessionScore() {
        return RecentSessionScore;
    }
    public void setRecentSessionScore(String recentSessionScore) {
        RecentSessionScore = recentSessionScore;
    }
    FileOutputStream outputStream;

    File files = new File(getFilesDir(), FILENAME1);

    // creates the recent sessions file when is called for the first time
    public boolean onCreateRecentSessionFile() {
        try {
            outputStream = openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            outputStream.write(RecentSessionDateCode.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionArithmeticType.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionOperationType.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionProbNum1.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionProbNum2.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionScore.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // updates the recent sessions file when called
    public boolean onUpdateRecentSessionFile() {
        try {
            outputStream = openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            outputStream.write(RecentSessionDateCode.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionArithmeticType.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionOperationType.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionProbNum1.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionProbNum2.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.write(RecentSessionScore.getBytes());
            outputStream.write("/n".getBytes());
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // deletes the contents of the recent sessions file when called
    public boolean onDeleteRecentSessionFileContent() {
        try {
            outputStream = openFileOutput(FILENAME1, Context.MODE_PRIVATE);
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
