package com.spizer.mizer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class ProblemSelector extends AppCompatActivity {

    @SuppressWarnings("unused")
    private boolean AddProb;
    @SuppressWarnings("unused")
    private boolean SubProb;
    @SuppressWarnings("unused")
    private boolean MultiProb;
    @SuppressWarnings("unused")
    private boolean DivisProb;

//    public boolean isAddProb() {
//        return AddProb;
//    }
//
//    public void setAddProb(boolean addProb) {
//        AddProb = addProb;
//    }
//
//    public boolean isSubProb() {
//        return SubProb;
//    }
//
//    public void setSubProb(boolean subProb) {
//        SubProb = subProb;
//    }
//
//    public boolean isMultiProb() {
//        return MultiProb;
//    }
//
//    public void setMultiProb(boolean multiProb) {
//        MultiProb = multiProb;
//    }
//
//    public boolean isDivisProb() {
//        return DivisProb;
//    }
//
//    public void setDivisProb(boolean divisProb) {
//        DivisProb = divisProb;
//    }

    @SuppressWarnings("unused")
    public int ANum = 0;
    @SuppressWarnings("unused")
    private int SNum;
    @SuppressWarnings("unused")
    private int MNum;
    @SuppressWarnings("unused")
    private int DNum;

    private final DifficultyMenu DM = new DifficultyMenu();
    private final BasicsPractice BP = new BasicsPractice();

    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox checkbox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_selector);

        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkBox4);

        /** waits for checkbox1 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String S = String.valueOf(b);
                Log.d("ProblemSelector.java","Line: 47 : " + S);
                if (b) {
                    @SuppressWarnings("UnusedAssignment") boolean AddProb = true;
                    DM.AddP = true;
                    BP.AddP = true;
                    Toast.makeText(getBaseContext(), "Addition: True", Toast.LENGTH_SHORT).show();
                    System.out.println("Addition: True");
                    Log.d("ProblemSelector.java","AddProb did successfully change to true");
                } else {
                    @SuppressWarnings("UnusedAssignment") boolean AddProb = false;
                    DM.AddP = false;
                    BP.AddP = false;
                    Toast.makeText(getBaseContext(), "Addition: False", Toast.LENGTH_SHORT).show();
                    System.out.println("Addition: False");
                    Log.d("ProblemSelector.java","AddProb did not successfully change to false");
                }
            }
        });

        /** waits for checkbox2 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    @SuppressWarnings("UnusedAssignment") boolean SubProb = true;
                    DM.SubP = true;
                    BP.SubP = true;
                    Toast.makeText(getBaseContext(), "Subtraction: True", Toast.LENGTH_SHORT).show();
                    System.out.println("Subtraction: True");
                    Log.d("ProblemSelector.java","SubProb did successfully change to true");
                    if(!AddProb) {
                        SNum = 0;
                    }
                    else {
                        SNum = 1;
                    }
                } else {
                    @SuppressWarnings("UnusedAssignment") boolean SubProb = false;
                    DM.SubP = false;
                    BP.SubP = false;
                    Toast.makeText(getBaseContext(), "Subtraction: False", Toast.LENGTH_SHORT).show();
                    System.out.println("Subtraction: False");
                    Log.d("ProblemSelector.java","SubProb did not successfully change to false");
                }
            }
        });

        /** waits for checkbox3 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    @SuppressWarnings("UnusedAssignment") boolean MultiProb = true;
                    DM.MultiP = true;
                    BP.MultiP = true;
                    Toast.makeText(getBaseContext(), "Multiplication: True", Toast.LENGTH_SHORT).show();
                    System.out.println("Multiplication: True");
                    Log.d("ProblemSelector.java","MultiProb did successfully change to true");
                    if(!AddProb && !SubProb) {
                        MNum = 0;
                    }
                    else if(AddProb && !SubProb || !AddProb) {
                        MNum = 1;
                    }
                    else {
                        MNum = 2;
                    }
                } else {
                    @SuppressWarnings("UnusedAssignment") boolean MultiProb = false;
                    DM.MultiP = false;
                    BP.MultiP = false;
                    Toast.makeText(getBaseContext(), "Multiplication: False", Toast.LENGTH_SHORT).show();
                    System.out.println("Multiplication: False");
                    Log.d("ProblemSelector.java","MultiProb did not successfully change to false");
                }
            }
        });

        /** waits for checkbox4 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        /** and determines if the value of the boolean for this function has changed successfully or not **/
        checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    @SuppressWarnings("UnusedAssignment") boolean DivisProb = true;
                    DM.DivisP = true;
                    BP.DivisP = true;
                    Toast.makeText(getBaseContext(), "Division: True", Toast.LENGTH_SHORT).show();
                    System.out.println("Division: True");
                    Log.d("ProblemSelector.java","DivisProb did successfully change to true");
                    if(!AddProb && !SubProb && !MultiProb) {
                        DNum = 0;
                    }
                    else if(AddProb && !SubProb && !MultiProb || !AddProb && SubProb && !MultiProb || !AddProb && !SubProb) {
                        DNum = 1;
                    }
                    else if(AddProb && SubProb && !MultiProb || !AddProb || AddProb && !SubProb) {
                        DNum = 2;
                    }
                    else {
                        DNum = 3;
                    }
                } else {
                    @SuppressWarnings("UnusedAssignment") boolean DivisProb = false;
                    DM.DivisP = false;
                    BP.DivisP = false;
                    Toast.makeText(getBaseContext(), "Division: False", Toast.LENGTH_SHORT).show();
                    System.out.println("Division: False");
                    Log.d("ProblemSelector.java","DivisProb did not successfully change to false");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_problem_selector, menu);
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

    /** this is called when the user hits the continue button **/
    public void DifficultyMenu(View view) {
        String S1 = String.valueOf(AddProb);
        Log.d("ProblemSelector.java","AddProb: " + S1);
        Intent DifficultyView = new Intent(this, DifficultyMenu.class);
        //DifficultyView.putExtra("addProb", PS.AddProb);
        //DifficultyView.putExtra("subProb", PS.SubProb);
        //DifficultyView.putExtra("multiProb", PS.MultiProb);
        //DifficultyView.putExtra("divisProb", PS.DivisProb);
        startActivity(DifficultyView);
    }

    /** this converts the 1st version bools to 2nd version bools and outputs the values to the command line **/
//    public boolean AddP = AddProb;
//    public boolean SubP = SubProb;
//    public boolean MultiP = MultiProb;
//    public boolean DivisP = DivisProb;
//
//    public boolean isAddProb() {
//        return AddProb;
//    }
//
//    public void setAddProb(boolean addProb) {
//        AddProb = addProb;
//    }
//
//    public boolean isAddP() {
//        return AddP;
//    }
//
//    public void setAddP(boolean addP) {
//        AddP = addP;
//    }
//
//    public boolean isSubP() {
//        return SubP;
//    }
//
//    public void setSubP(boolean subP) {
//        SubP = subP;
//    }
//
//    public boolean isMultiP() {
//        return MultiP;
//    }
//
//    public void setMultiP(boolean multiP) {
//        MultiP = multiP;
//    }
//
//    public boolean isDivisP() {
//        return DivisP;
//    }
//
//    public void setDivisP(boolean divisP) {
//        DivisP = divisP;
//    }
}
