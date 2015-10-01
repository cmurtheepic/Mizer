package com.spizer.mizer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public boolean PreviousSession = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
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
            System.out.println("Something when terribly wrong at line: 45");
        }
    }

    /** called when the user clicks a button for a feature that currently does not exist in the
     * application or that currently does not work
     */
    public void NotWorking(View view) {
        Intent NotWorkingView = new Intent(this, NotWorking.class);
        startActivity(NotWorkingView);
    }

}
