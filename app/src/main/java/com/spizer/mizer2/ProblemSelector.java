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

    public boolean AddProb = true;
    public boolean SubProb = true;
    public boolean MultiProb = true;
    public boolean DivisProb = true;

    public boolean getAddProb() {
        return AddProb;
    }

    public void setAddProb(boolean addProb) {
        AddProb = addProb;
    }

    public boolean getSubProb() {
        return SubProb;
    }

    public void setSubProb(boolean subProb) {
        SubProb = subProb;
    }

    public boolean getMultiProb() {
        return MultiProb;
    }

    public void setMultiProb(boolean multiProb) {
        MultiProb = multiProb;
    }

    public boolean getDivisProb() {
        return DivisProb;
    }

    public void setDivisProb(boolean divisProb) {
        DivisProb = divisProb;
    }

    @SuppressWarnings("unused")
    public int ANum = 0;
    @SuppressWarnings("unused")
    public int SNum = 1;
    @SuppressWarnings("unused")
    public int MNum = 2;
    @SuppressWarnings("unused")
    public int DNum = 3;

    public int getANum() {
        return ANum;
    }

    public int getSNum() {
        return SNum;
    }

    public void setSNum(int SNum) {
        this.SNum = SNum;
    }

    public int getMNum() {
        return MNum;
    }

    public void setMNum(int MNum) {
        this.MNum = MNum;
    }

    public int getDNum() {
        return DNum;
    }

    public void setDNum(int DNum) {
        this.DNum = DNum;
    }

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
                Log.d("ProblemSelector.java", "Line: 47 : " + S);
                if (b) {
//                    AddProb = true;
                    setAddProb(true);
                    Toast.makeText(getBaseContext(), "Addition: True", Toast.LENGTH_SHORT).show();
                } else {
//                    AddProb = false;
                    setAddProb(false);
                    Toast.makeText(getBaseContext(), "Addition: False", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /** waits for checkbox2 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
//                    SubProb = true;
                    setSubProb(true);
                    Toast.makeText(getBaseContext(), "Subtraction: True", Toast.LENGTH_SHORT).show();
                    if (!AddProb) {
                        SNum = 0;
                        setSNum(0);
                    } else {
                        SNum = 1;
                        setSNum(1);
                    }
                } else {
//                    SubProb = false;
                    setSubProb(false);
                    Toast.makeText(getBaseContext(), "Subtraction: False", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /** waits for checkbox3 to be clicked then triggers the arguments below it **/
        /** also sets the lists position if the other problems for training have been selected to practice **/
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
//                    MultiProb = true;
                    setMultiProb(true);
                    Toast.makeText(getBaseContext(), "Multiplication: True", Toast.LENGTH_SHORT).show();
                    if (!AddProb && !SubProb) {
                        MNum = 0;
                        setMNum(0);
                    } else if (AddProb && !SubProb || !AddProb) {
                        MNum = 1;
                        setMNum(1);
                    } else {
                        MNum = 2;
                        setMNum(2);
                    }
                } else {
//                    MultiProb = false;
                    setMultiProb(false);
                    Toast.makeText(getBaseContext(), "Multiplication: False", Toast.LENGTH_SHORT).show();
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
//                    DivisProb = true;
                    setDivisProb(true);
                    Toast.makeText(getBaseContext(), "Division: True", Toast.LENGTH_SHORT).show();
                    if (!AddProb && !SubProb && !MultiProb) {
                        DNum = 0;
                        setDNum(0);
                    } else if (AddProb && !SubProb && !MultiProb || !AddProb && SubProb && !MultiProb || !AddProb && !SubProb) {
                        DNum = 1;
                        setDNum(1);
                    } else if (AddProb && SubProb && !MultiProb || !AddProb || AddProb && !SubProb) {
                        DNum = 2;
                        setDNum(2);
                    } else {
                        DNum = 3;
                        setDNum(3);
                    }
                } else {
//                    DivisProb = false;
                    setDivisProb(false);
                    Toast.makeText(getBaseContext(), "Division: False", Toast.LENGTH_SHORT).show();
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

    /**
     * this is called when the user hits the continue button
     **/
    public void DifficultyMenu(View view) {
        Log.d("ProblemSelector.java","the value of ANum = " + getANum() + " : the value of SNum = " + getSNum());
        Log.d("ProblemSelector.java", "the value of AddProb = " + AddProb + " : the value of SubProb = " + SubProb + " : the value of MultiProb = " + MultiProb + " : the value of DivisProb = " + DivisProb);
        Intent DifficultyView = new Intent(this, DifficultyMenu.class);
        startActivity(DifficultyView);
    }
}