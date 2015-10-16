package com.spizer.mizer2;

<<<<<<< HEAD:app/src/main/java/com/spizer/mizer2/MainActivity.java
import android.app.Activity;
import android.content.Intent;
=======
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
>>>>>>> master:app/src/main/java/com/spizer/mizer2/Start/MainActivity.java
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

<<<<<<< HEAD:app/src/main/java/com/spizer/mizer2/MainActivity.java
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import com.spizer.mizer2.Start.MathProblemSelector;
=======
import com.spizer.mizer2.basics.Score;
>>>>>>> master:app/src/main/java/com/spizer/mizer2/Start/MainActivity.java
import com.spizer.mizer2.otherclasses.NotWorking;
import com.spizer.mizer2.utilityclasses.SettingsActivity;

public class MainActivity extends Activity {

    public boolean PreviousSession = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD:app/src/main/java/com/spizer/mizer2/MainActivity.java
        Bundle extras = new Bundle();
        extras.putBoolean("is_designed_for_families", true);

        /** finds the ad view by its ID, then requests a new AD to be built **/
        AdView mAdView = (AdView) findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
                .addTestDevice("2A67F802D66C64C858760E73C4C62333") // My Samsung Galaxy Note 4
                //.addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build(); // Builds the AD

        mAdView.loadAd(adRequest);

=======
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
>>>>>>> master:app/src/main/java/com/spizer/mizer2/Start/MainActivity.java
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent SettingsV = new Intent(this, SettingsActivity.class);
            startActivity(SettingsV);
        }

        return super.onOptionsItemSelected(item);
    }

    /** called when the user clicks the START button **/
    /** unless it was the first time starting the app **/
    public void MPS(View view) {
        if (!PreviousSession) {
            Intent OpenMPS = new Intent(this, MathProblemSelector.class);
            startActivity(OpenMPS);
        } else {
            System.out.println("Something went terribly wrong at line: 45");
        }
    }

    /** called when the user clicks a button for a feature that currently does not exist in the
     * application or that currently does not work
     */
    public void NotWorking(View view) {
        Intent NotWorkingView = new Intent(this, NotWorking.class);
        startActivity(NotWorkingView);
    }

<<<<<<< HEAD:app/src/main/java/com/spizer/mizer2/MainActivity.java
    /** called when the user clicks the settings button
     */
    public void Settings(View view) {
        Intent SettingsV = new Intent(this, SettingsActivity.class);
        startActivity(SettingsV);
=======
    // called when the user clicks the rate button
    public void Rate(View view) {

>>>>>>> master:app/src/main/java/com/spizer/mizer2/Start/MainActivity.java
    }
}
