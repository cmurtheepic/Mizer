package com.spizer.mizer2.otherclasses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.spizer.mizer2.R;
import com.spizer.mizer2.Start.SessionMenuActivity;
import com.spizer.mizer2.utilityclasses.SettingsActivity;

public class NotWorking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_working);

        Bundle extras = new Bundle();
        extras.putBoolean("is_designed_for_families", true);

//        /** finds the ad view by its ID, then requests a new AD to be built **/
//        AdView mAdView1 = (AdView) findViewById(R.id.adView4);
//        AdView mAdView2 = (AdView) findViewById(R.id.adView5);
//
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
//                .addTestDevice("2A67F802D66C64C858760E73C4C62333") // My Samsung Galaxy Note 4
//                //.addNetworkExtrasBundle(AdMobAdapter.class, extras)
//                .build(); // Builds the AD
//
//        mAdView1.loadAd(adRequest);
//        mAdView2.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_not_working, menu);
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

    ImageButton iB_button;

    /** this creates the imageview and sets the image tobe displayed in the image button **/
    public void MakeView() {
        iB_button = (ImageButton) findViewById(R.id.imageButton);
        iB_button.setImageResource(R.mipmap.notfound);
    }

    /** this opens the sessionMenu when the user clicks the image button **/
    public void SessionMenu(View view) {
        Intent openSessionMenu = new Intent(this, SessionMenuActivity.class);
        startActivity(openSessionMenu);
    }

}
