package com.spizer.mizer2.Start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.spizer.mizer2.otherclasses.NotWorking;
import com.spizer.mizer2.basics.ProblemSelector;
import com.spizer.mizer2.R;

public class SessionMenuActivity extends AppCompatActivity {

    private boolean PrevSession;

    public boolean getPrevSess() {
        return PrevSession;
    }

    public void setPrevSess(boolean prevSession) {
        PrevSession = prevSession;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_menu);

        Bundle extras = new Bundle();
        extras.putBoolean("is_designed_for_families", true);

        /** finds the ad view by its ID, then requests a new AD to be built **/
        AdView mAdView = (AdView) findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
                .addTestDevice("2A67F802D66C64C858760E73C4C62333") // My Samsung Galaxy Note 4
                //.addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build(); // Builds the AD

        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_session_menu, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** called when the user clicks the START SESSION button **/
    public void ProblemSelectorMenu(View view) {
        Intent OpenProblemSelectorMenu = new Intent(this, ProblemSelector.class);
        startActivity(OpenProblemSelectorMenu);
    }

    /** called when the user clicks the RESUME PREVIOUS SESSION button **/
   /** public void ResumePreviousSession(View view) {
   *     Intent ResumeSession = new Intent(this, PreviousSession.class);
   *     startActivity(ResumeSession);
    } **/

    /** called when the user clicks a button for a feature that currently does not exist in the
     * application or that currently does not work
     */
    public void NotWorking(View view) {
        Intent NotWorkingView = new Intent(this, NotWorking.class);
        startActivity(NotWorkingView);
    }

}
