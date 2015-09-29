package com.spizer.mizer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class BasicsPractice extends AppCompatActivity {

    /** calls to make the class ProblemSelector usable in this class **/
    @SuppressWarnings("unused")
    private ProblemSelector PS = new ProblemSelector();

    /** calls to make the class DifficultyMenu usable in this class **/
    private DifficultyMenu DM = new DifficultyMenu();

    private TextView PO;

    private String B1;
    private String B2;
    private String B3;
    private String B4;
    private String B5;
    private String B6;
    private String B7;
    private String B8;
    private String B9;

    private String Output;

    @SuppressWarnings("unused")
    private Random r;

    private int Max1;

    public int AD = DM.AD;
    public int SD = DM.SD;
    public int MD = DM.MD;
    public int DD = DM.DD;

    public boolean AddP = PS.AddProb;
    public boolean SubP = PS.SubProb;
    public boolean MultiP = PS.MultiProb;
    public boolean DivisP = PS.DivisProb;

    public boolean AChecked = DM.AChecked;
    public boolean SChecked = DM.SChecked;
    public boolean MChecked = DM.MChecked;
    public boolean DChecked = DM.DChecked;

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
        int AS1 = 0;
        Double d = Math.random() * Max1;
        int o1 = d.intValue();
        Log.d("BasicsPractice.java","the GenerateOperation function generated : " + o1 + " : as the number to determine the operation to be built");
        if(o1 == 0) {
            if(AddP) {
//                int AD = DM.AddDiff + 1;
                Log.d("BasicsPractice.java","the add difficulty is : " + AD);
//                Double d1 = Math.random() * AD;
//                A1 = d1.intValue();
                int a1 = (int) (Math.random() * 11);
                //int A1 = r.nextInt(DM.AddDiff + 1);
                Log.d("BasicsPractice.java","the first Addition number generated was: " + a1);
//                Double d5 = Math.random() * AD;
//                A2 = d5.intValue();
                int a2 = (int) (Math.random() * 11);
                //A2 = r.nextInt(DM.AddDiff + 1);
                Log.d("BasicsPractice.java","the second Addition number generated was: " + a2);
                Output = a1 + " + " + a2;
                Log.d("BasicsPractice.java", "the outputted problem was: " + Output);
                Double D1 = Math.random() * 8;
                int S1 = D1.intValue();
                if(S1 == 0) {
                    AS1 = a1 + a2;
                    B1 = Integer.toString(AS1);
                } else if(S1 == 1) {
                    B2 = Integer.toString(AS1);
                } else if(S1 == 2) {
                    B3 = Integer.toString(AS1);
                } else if(S1 == 3) {
                    B4 = Integer.toString(AS1);
                }else if(S1 == 4) {
                    B5 = Integer.toString(AS1);
                } else if(S1 == 5) {
                    B6 = Integer.toString(AS1);
                } else if(S1 == 6) {
                    B7 = Integer.toString(AS1);
                } else if(S1 == 7) {
                    B8 = Integer.toString(AS1);
                }else if(S1 == 8) {
                    B9 = Integer.toString(AS1);
                } else {
                    Log.e("BasicsPractice.java","Something went horribly wrong on line : 160-181");
                }
                Log.d("BasicsPractice.java","the button number is : " + S1 + 1);
                Log.d("BasicsPractice.java","the button output is : " + AS1);
                OutputToAnswerSelection();
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
                Double D1 = Math.random() * 8;
                int S1 = D1.intValue();
                if(S1 == 0) {
                    AS1 = s1 - s2;
                    B1 = Integer.toString(AS1);
                } else if(S1 == 1) {
                    B2 = Integer.toString(AS1);
                } else if(S1 == 2) {
                    B3 = Integer.toString(AS1);
                } else if(S1 == 3) {
                    B4 = Integer.toString(AS1);
                }else if(S1 == 4) {
                    B5 = Integer.toString(AS1);
                } else if(S1 == 5) {
                    B6 = Integer.toString(AS1);
                } else if(S1 == 6) {
                    B7 = Integer.toString(AS1);
                } else if(S1 == 7) {
                    B8 = Integer.toString(AS1);
                }else if(S1 == 8) {
                    B9 = Integer.toString(AS1);
                } else {
                    Log.e("BasicsPractice.java","Something went horribly wrong on line : 196-217");
                }
                OutputToAnswerSelection();
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
                Double D1 = Math.random() * 8;
                int S1 = D1.intValue();
                if(S1 == 0) {
                    AS1 = m1 * m2;
                    B1 = Integer.toString(AS1);
                } else if(S1 == 1) {
                    B2 = Integer.toString(AS1);
                } else if(S1 == 2) {
                    B3 = Integer.toString(AS1);
                } else if(S1 == 3) {
                    B4 = Integer.toString(AS1);
                }else if(S1 == 4) {
                    B5 = Integer.toString(AS1);
                } else if(S1 == 5) {
                    B6 = Integer.toString(AS1);
                } else if(S1 == 6) {
                    B7 = Integer.toString(AS1);
                } else if(S1 == 7) {
                    B8 = Integer.toString(AS1);
                }else if(S1 == 8) {
                    B9 = Integer.toString(AS1);
                } else {
                    Log.e("BasicsPractice.java","Something went horribly wrong on line : 232-253");
                }
                OutputToAnswerSelection();
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
                Double D1 = Math.random() * 9;
                int S1 = D1.intValue();
                if(S1 == 0) {
                    AS1 = d1 / d2;
                    B1 = Integer.toString(AS1);
                } else if(S1 == 1) {
                    B2 = Integer.toString(AS1);
                } else if(S1 == 2) {
                    B3 = Integer.toString(AS1);
                } else if(S1 == 3) {
                    B4 = Integer.toString(AS1);
                }else if(S1 == 4) {
                    B5 = Integer.toString(AS1);
                } else if(S1 == 5) {
                    B6 = Integer.toString(AS1);
                } else if(S1 == 6) {
                    B7 = Integer.toString(AS1);
                } else if(S1 == 7) {
                    B8 = Integer.toString(AS1);
                }else if(S1 == 8) {
                    B9 = Integer.toString(AS1);
                } else {
                    Log.e("BasicsPractice.java","Something went horribly wrong on line : 268-289");
                }
                Log.d("BasicsPractice.java","the button number is : " + S1 + 1);
                Log.d("BasicsPractice.java","the button output is : " + AS1);
                OutputToAnswerSelection();
                OutputToProblemView();
            }
        }
    }

    private void generateAnswerOutputs() {

    }

    private void OutputToProblemView() {
        PO.setText(Output);
    }

    private void OutputToAnswerSelection() {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        try {button1.setText(B1);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B2);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B3);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B4);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B5);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B6);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B7);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B8);} catch (Exception e) { e.printStackTrace(); }
        try {button2.setText(B9);} catch (Exception e) { e.printStackTrace(); }
    }

    public void Skip(@SuppressWarnings("UnusedParameters") View view) {
        GenerateOperation();
    }
}
