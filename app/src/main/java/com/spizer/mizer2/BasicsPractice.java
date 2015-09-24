package com.spizer.mizer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class BasicsPractice extends AppCompatActivity {

    private TextView PO;

    private String Output;

    @SuppressWarnings("unused")
    private Random r;

    private int Max1;

    public int AD;
    public int SD;
    public int MD;
    public int DD;

    @SuppressWarnings("unused")
    public int getAD() {
        return AD;
    }

    public void setAD(int AD) {
        this.AD = AD;
    }

    @SuppressWarnings("unused")
    public int getSD() {
        return SD;
    }

    @SuppressWarnings("unused")
    public void setSD(int SD) {
        this.SD = SD;
    }

    @SuppressWarnings("unused")
    public int getMD() {
        return MD;
    }

    @SuppressWarnings("unused")
    public void setMD(int MD) {
        this.MD = MD;
    }

    @SuppressWarnings("unused")
    public int getDD() {
        return DD;
    }

    @SuppressWarnings("unused")
    public void setDD(int DD) {
        this.DD = DD;
    }

    public boolean AddP;
    public boolean SubP;
    public boolean MultiP;
    public boolean DivisP;

    @SuppressWarnings("unused")
    public boolean isAddP() {
        return AddP;
    }

    @SuppressWarnings("unused")
    public void setAddP(boolean addP) {
        AddP = addP;
    }

    @SuppressWarnings("unused")
    public boolean isSubP() {
        return SubP;
    }

    @SuppressWarnings("unused")
    public void setSubP(boolean subP) {
        SubP = subP;
    }

    @SuppressWarnings("unused")
    public boolean isMultiP() {
        return MultiP;
    }

    @SuppressWarnings("unused")
    public void setMultiP(boolean multiP) {
        MultiP = multiP;
    }

    @SuppressWarnings("unused")
    public boolean isDivisP() {
        return DivisP;
    }

    @SuppressWarnings("unused")
    public void setDivisP(boolean divisP) {
        DivisP = divisP;
    }

    /** calls to make the class ProblemSelector usable in this class **/
    @SuppressWarnings("unused")
    ProblemSelector PS = new ProblemSelector();

    /** calls to make the class DifficultyMenu usable in this class **/
    @SuppressWarnings("unused")
    DifficultyMenu DM = new DifficultyMenu();

    public boolean AChecked;
    public boolean SChecked;
    public boolean MChecked;
    public boolean DChecked;

    @SuppressWarnings("unused")
    public boolean isAChecked() {
        return AChecked;
    }

    @SuppressWarnings("unused")
    public void setAChecked(boolean AChecked) {
        this.AChecked = AChecked;
    }

    @SuppressWarnings("unused")
    public boolean isSChecked() {
        return SChecked;
    }

    @SuppressWarnings("unused")
    public void setSChecked(boolean SChecked) {
        this.SChecked = SChecked;
    }

    @SuppressWarnings("unused")
    public boolean isMChecked() {
        return MChecked;
    }

    @SuppressWarnings("unused")
    public void setMChecked(boolean MChecked) {
        this.MChecked = MChecked;
    }

    @SuppressWarnings("unused")
    public boolean isDChecked() {
        return DChecked;
    }

    @SuppressWarnings("unused")
    public void setDChecked(boolean DChecked) {
        this.DChecked = DChecked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_practice);
        PO = (TextView) findViewById(R.id.problemoutput);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basics_practice, menu);
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

        @SuppressWarnings("unused")
        public void generateNums() {
            if(AddP && AChecked && !SubP && !MultiP && !DivisP) {
                Max1 = 1;
            } else if(!AddP && SubP && SChecked && !MultiP && !DivisP) {
                Max1 = 1;
            } else if(!AddP && !SubP && MultiP && MChecked && !DivisP) {
                Max1 = 1;
            } else if(!AddP && !SubP && !MultiP && DivisP && DChecked) {
                Max1 = 1;
            } else if(AddP && AChecked && SubP && SChecked && !MultiP && !DivisP) {
                Max1 = 2;
            } else if(AddP && AChecked && !SubP && MultiP && MChecked && !DivisP) {
                Max1 = 2;
            } else if(AddP && AChecked && !SubP && !MultiP && DivisP && DChecked) {
                Max1 = 2;
            } else if(!AddP && SubP && SChecked && MultiP && MChecked && !DivisP) {
                Max1 = 2;
            } else if(!AddP && SubP && SChecked && !MultiP && DivisP && DChecked) {
                Max1 = 2;
            } else if(!AddP && !SubP && MultiP && MChecked && DivisP && DChecked) {
                Max1 = 2;
            } else if(AddP && AChecked && SubP && SChecked && MultiP && MChecked && !DivisP){
                Max1 = 3;
            } else if(AddP && AChecked && SubP && SChecked && !MultiP && DivisP && DChecked) {
                Max1 = 3;
            } else if(AddP && AChecked && !SubP && MultiP && MChecked && DivisP && DChecked) {
                Max1 = 3;
            } else if(!AddP && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
                Max1 = 3;
            } else if(AddP && AChecked && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
                Max1 = 4;
            } else {
                Log.e("BasicsPractice.java","Something went horribly wrong");
            }
            Max1 = Max1 + 1;
        }

    /** randomly generates a operation to do from a value of 0-value determined by operations the user has chosen to practice **/
    /** also generates 2 values for the user to add, subtract, multiply, or divide. to solve the problem **/
    private void GenerateOperation() {
        Double d = Math.random() * Max1;
        int o1 = d.intValue();
        Log.d("BasicsPractice.java","the GenerateOperation function generated : " + o1 + " : as the number to determine the operation to be built");
        if(o1 == 0) {
            if(AddP) {
//                int AD = DM.AddDiff + 1;
                Log.d("BasicsPractice.java","the add difficulty is : " + AD);
//                Double d1 = Math.random() * AD;
//                A1 = d1.intValue();
                int a1 = (int) (Math.random() * AD);
                //int A1 = r.nextInt(DM.AddDiff + 1);
                Log.d("BasicsPractice.java","the first Addition number generated was: " + a1);
//                Double d5 = Math.random() * AD;
//                A2 = d5.intValue();
                int a2 = (int) (Math.random() * AD);
                //A2 = r.nextInt(DM.AddDiff + 1);
                Log.d("BasicsPractice.java","the second Addition number generated was: " + a2);
                Output = a1 + " + " + a2;
                Log.d("BasicsPractice.java","the outputted problem was: " + Output);
                OutputToProblemView();
            }
        } else if(o1 == 1) {
            if(SubP) {
//                int SD = DM.SubDiff + 1;
                Double d2 = Math.random() * SD;
                int s1 = d2.intValue();
                Double d6 = Math.random() * SD;
                int s2 = d6.intValue();
                Output = s1 + " - " + s2;
                OutputToProblemView();
            }
        } else if(o1 == 2) {
            if(MultiP) {
//                int MD = DM.MultiDiff + 1;
                Double d3 = Math.random() * MD;
                int m1 = d3.intValue();
                Double d7 = Math.random() * MD;
                int m2 = d7.intValue();
                Output = m1 + " * " + m2;
                OutputToProblemView();
            }
        } else if(o1 == 3) {
            if(DivisP) {
//                int DD = DM.DivisDiff + 1;
                Double d4 = Math.random() * DD;
                int d1 = d4.intValue();
                Double d8 = Math.random() * DD;
                int d2 = d8.intValue();
                Output = d1 + " / " + d2;
                OutputToProblemView();
            }
        }
    }

    private void OutputToProblemView() {
        PO.setText(Output);
    }

    public void Skip(@SuppressWarnings("UnusedParameters") View view) {
        GenerateOperation();
    }
}
