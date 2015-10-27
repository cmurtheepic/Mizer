package com.spizer.mizer2.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.spizer.mizer2.basics.BasicsPractice;
import com.spizer.mizer2.R;
import com.spizer.mizer2.utilityclasses.SettingsActivity;

public class MathProblemSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_problem_selector);

        Button basics = (Button) findViewById(R.id.BasicsButton);
        basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent base = new Intent(MathProblemSelector.this, BasicsPractice.class);
                overridePendingTransition(R.anim.basicstrans1in, R.anim.basicstrans2out);
                startActivity(base);
            }
        });

//        Bundle extras = new Bundle();
//        extras.putBoolean("is_designed_for_families", true);
//
//        /** finds the ad view by its ID, then requests a new AD to be built **/
//        AdView mAdView = (AdView) findViewById(R.id.adView3);
//
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
//                .addTestDevice("2A67F802D66C64C858760E73C4C62333") // My Samsung Galaxy Note 4
//               // .addNetworkExtrasBundle(AdMobAdapter.class, extras)
//                .build(); // Builds the AD
//
//        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math_problem_selector, menu);
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

    /** called when the user clicks the ALGEBRA button **/
    /** currently does not have Algebra practice mode **/
//    public void Algebra(View view) {
//        Intent AlgebraView = new Intent(this, NotWorking.class);
//        startActivity(AlgebraView);
//    }
//
//    /** called when the user clicks the GEOMETRY button **/
//    /** currently does not have Geometry practice mode **/
//    public void Geometry(View view) {
//        Intent GeometryView = new Intent(this, NotWorking.class);
//        startActivity(GeometryView);
//    }
}
