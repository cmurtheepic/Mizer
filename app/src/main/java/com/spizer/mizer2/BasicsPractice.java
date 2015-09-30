package com.spizer.mizer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import java.util.Random;

public class BasicsPractice extends AppCompatActivity {

    /**
     * calls to make the class ProblemSelector usable in this class
     **/
    @SuppressWarnings("unused")
    private ProblemSelector PS = new ProblemSelector();

    /**
     * calls to make the class DifficultyMenu usable in this class
     **/
    private DifficultyMenu DM = new DifficultyMenu();

    private TextView PO;

    private TextView C;
    private TextView IC;

    private TextView S;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    private String B1;
    private String B2;
    private String B3;
    private String B4;
    private String B5;
    private String B6;
    private String B7;
    private String B8;
    private String B9;

    public String getB1() {
        return B1;
    }

    public void setB1(String b1) {
        B1 = b1;
    }

    public String getB2() {
        return B2;
    }

    public void setB2(String b2) {
        B2 = b2;
    }

    public String getB3() {
        return B3;
    }

    public void setB3(String b3) {
        B3 = b3;
    }

    public String getB4() {
        return B4;
    }

    public void setB4(String b4) {
        B4 = b4;
    }

    public String getB5() {
        return B5;
    }

    public void setB5(String b5) {
        B5 = b5;
    }

    public String getB6() {
        return B6;
    }

    public void setB6(String b6) {
        B6 = b6;
    }

    public String getB7() {
        return B7;
    }

    public void setB7(String b7) {
        B7 = b7;
    }

    public String getB8() {
        return B8;
    }

    public void setB8(String b8) {
        B8 = b8;
    }

    public String getB9() {
        return B9;
    }

    public void setB9(String b9) {
        B9 = b9;
    }

    private String Output;

    @SuppressWarnings("unused")
    private Random r;

    private int Max1 = 4;

    public int AD = DM.getAD();
    public int SD = DM.getSD();
    public int MD = DM.getMD();
    public int DD = DM.getDD();

    public boolean AddP = PS.getAddProb();
    public boolean SubP = PS.getSubProb();
    public boolean MultiP = PS.getMultiProb();
    public boolean DivisP = PS.getDivisProb();

    public boolean AChecked = DM.getAChecked();
    public boolean SChecked = DM.getSChecked();
    public boolean MChecked = DM.getMChecked();
    public boolean DChecked = DM.getDChecked();

    private boolean AddProbT;
    private boolean SubProbT;
    private boolean MultiProbT;
    private boolean DivisProbT;

    public boolean getAddProbT() {
        return AddProbT;
    }

    public void setAddProbT(boolean addProbT) {
        AddProbT = addProbT;
    }

    public boolean getSubProbT() {
        return SubProbT;
    }

    public void setSubProbT(boolean subProbT) {
        SubProbT = subProbT;
    }

    public boolean getMultiProbT() {
        return MultiProbT;
    }

    public void setMultiProbT(boolean multiProbT) {
        MultiProbT = multiProbT;
    }

    public boolean getDivisProbT() {
        return DivisProbT;
    }

    public void setDivisProbT(boolean divisProbT) {
        DivisProbT = divisProbT;
    }

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int SS1;

    public int getSS1() {
        return SS1;
    }

    public void setSS1(int SS1) {
        this.SS1 = SS1;
    }

    private int S1;

    public int getS1() {
        return S1;
    }

    public void setS1(int s1) {
        S1 = s1;
    }

    Handler Handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_practice);
        PO = (TextView) findViewById(R.id.problemoutput);
        C = (TextView) findViewById(R.id.correctTextView);
        IC = (TextView) findViewById(R.id.IncorrectTextView);
        S = (TextView) findViewById(R.id.scoreView);

        S.setText(Integer.toString(score));

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(myB1);
        button2.setOnClickListener(myB2);
        button3.setOnClickListener(myB3);
        button4.setOnClickListener(myB4);
        button5.setOnClickListener(myB5);
        button6.setOnClickListener(myB6);
        button7.setOnClickListener(myB7);
        button8.setOnClickListener(myB8);
        button9.setOnClickListener(myB9);

//        generateNums();
        GenerateOperation();
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
    private void generateNums() {
        if (AddP && AChecked && !SubP && !MultiP && !DivisP) {
            Max1 = 1;
        } else if (!AddP && SubP && SChecked && !MultiP && !DivisP) {
            Max1 = 1;
        } else if (!AddP && !SubP && MultiP && MChecked && !DivisP) {
            Max1 = 1;
        } else if (!AddP && !SubP && !MultiP && DivisP && DChecked) {
            Max1 = 1;
        } else if (AddP && AChecked && SubP && SChecked && !MultiP && !DivisP) {
            Max1 = 2;
        } else if (AddP && AChecked && !SubP && MultiP && MChecked && !DivisP) {
            Max1 = 2;
        } else if (AddP && AChecked && !SubP && !MultiP && DivisP && DChecked) {
            Max1 = 2;
        } else if (!AddP && SubP && SChecked && MultiP && MChecked && !DivisP) {
            Max1 = 2;
        } else if (!AddP && SubP && SChecked && !MultiP && DivisP && DChecked) {
            Max1 = 2;
        } else if (!AddP && !SubP && MultiP && MChecked && DivisP && DChecked) {
            Max1 = 2;
        } else if (AddP && AChecked && SubP && SChecked && MultiP && MChecked && !DivisP) {
            Max1 = 3;
        } else if (AddP && AChecked && SubP && SChecked && !MultiP && DivisP && DChecked) {
            Max1 = 3;
        } else if (AddP && AChecked && !SubP && MultiP && MChecked && DivisP && DChecked) {
            Max1 = 3;
        } else if (!AddP && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
            Max1 = 3;
        } else if (AddP && AChecked && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
            Max1 = 4;
        } else {
            Log.e("BasicsPractice.java", "Something went horribly wrong at line : 119");
        }
        Max1 = Max1 + 1;
    }

    /** randomly generates a operation to do from a value of 0-value determined by operations the user has chosen to practice **/
    /** also generates 2 values for the user to add, subtract, multiply, or divide. to solve the problem **/
    private void GenerateOperation() {
        int AS1;
        Double d = Math.random() * Max1;
        setS1((int) (Math.random() * 9));
        int o1 = d.intValue();
        Log.d("BasicsPractice.java", "the GenerateOperation function generated : " + o1 + " : as the number to determine the operation to be built");
        if (o1 == 0) {
            if (AddP) {
                setAddProbT(true);
                setSubProbT(false);
                setMultiProbT(false);
                setDivisProbT(false);
                Log.d("BasicsPractice.java", "the add difficulty is : " + AD);
                int a1 = (int) (Math.random() * DM.getAD());
                Log.d("BasicsPractice.java", "the first Addition number generated was: " + a1);
                int a2 = (int) (Math.random() * DM.getAD());
                Log.d("BasicsPractice.java", "the second Addition number generated was: " + a2);
                AS1 = a1 + a2;
                Output = a1 + " + " + a2;
                Log.d("BasicsPractice.java", "the outputted problem was: " + Output);
                if (getS1() == 0) {
                    B1 = Integer.toString(AS1);
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 1) {
                    B2 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 2) {
                    B3 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 3) {
                    B4 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 4) {
                    B5 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 5) {
                    B6 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 6) {
                    B7 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 7) {
                    B8 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else if (S1 == 8) {
                    B9 = Integer.toString(AS1);
                    B8 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getAD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getAD()));
                } else {
                    Log.e("BasicsPractice.java", "Something went horribly wrong on line : 160-181");
                }
                Log.d("BasicsPractice.java", "the button number is : " + S1 + 1);
                Log.d("BasicsPractice.java", "the button output is : " + AS1);
                OutputToAnswerSelection();
                OutputToProblemView();
            }
        } else if (o1 == 1) {
            if (SubP) {
                setAddProbT(false);
                setSubProbT(true);
                setMultiProbT(false);
                setDivisProbT(false);
                Double d2 = Math.random() * DM.getSD();
                int s1 = d2.intValue();
                Double d6 = Math.random() * DM.getSD();
                int s2 = d6.intValue();
                AS1 = s1 - s2;
                Output = s1 + " - " + s2;
                if (getS1() == 0) {
                    B1 = Integer.toString(AS1);
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 1) {
                    B2 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 2) {
                    B3 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 3) {
                    B4 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 4) {
                    B5 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 5) {
                    B6 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 6) {
                    B7 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 7) {
                    B8 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else if (S1 == 8) {
                    B9 = Integer.toString(AS1);
                    B8 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getSD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getSD()));
                } else {
                    Log.e("BasicsPractice.java", "Something went horribly wrong on line : 160-181");
                }
                OutputToAnswerSelection();
                OutputToProblemView();
            }
        } else if (o1 == 2) {
            if (MultiP) {
                setAddProbT(false);
                setSubProbT(false);
                setMultiProbT(true);
                setDivisProbT(false);
                Double d3 = Math.random() * DM.getMD();
                int m1 = d3.intValue();
                Double d7 = Math.random() * DM.getMD();
                int m2 = d7.intValue();
                AS1 = m1 * m2;
                Output = m1 + " * " + m2;
                if (getS1() == 0) {
                    B1 = Integer.toString(AS1);
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 1) {
                    B2 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 2) {
                    B3 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 3) {
                    B4 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 4) {
                    B5 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 5) {
                    B6 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 6) {
                    B7 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 7) {
                    B8 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else if (S1 == 8) {
                    B9 = Integer.toString(AS1);
                    B8 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getMD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getMD()));
                } else {
                    Log.e("BasicsPractice.java", "Something went horribly wrong on line : 160-181");
                }
                OutputToAnswerSelection();
                OutputToProblemView();
            }
        } else if (o1 == 3) {
            if (DivisP) {
                setAddProbT(false);
                setSubProbT(false);
                setMultiProbT(false);
                setDivisProbT(true);
                Double d4 = Math.random() * DM.getDD();
                int d1 = d4.intValue();
                Double d8 = Math.random() * DM.getDD();
                int d2 = d8.intValue();
                AS1 = d1 / d2;
                Output = d1 + " / " + d2;
                if (getS1() == 0) {
                    B1 = Integer.toString(AS1);
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 1) {
                    B2 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 2) {
                    B3 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 3) {
                    B4 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 4) {
                    B5 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 5) {
                    B6 = Integer.toString(AS1);
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 6) {
                    B7 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 7) {
                    B8 = Integer.toString(AS1);
                    B9 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else if (S1 == 8) {
                    B9 = Integer.toString(AS1);
                    B8 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B7 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B6 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B5 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B4 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B3 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B2 = Integer.toString((int) (Math.random() * DM.getDD()));
                    B1 = Integer.toString((int) (Math.random() * DM.getDD()));
                } else {
                    Log.e("BasicsPractice.java", "Something went horribly wrong on line : 160-181");
                }
                OutputToAnswerSelection();
                OutputToProblemView();
            }
        }
    }

    /** this outputs the value of the String *Output* to the Output text field on screen **/
    /** this is the problem the user must solver to either get a correct or incorrect answer **/
    private void OutputToProblemView() {
        PO.setText(Output);
    }

    /** this outputs the value of the B(num) int variables to the desired button on screen that in the Ui **/
    /** the desired button will be the correct answer **/
    private void OutputToAnswerSelection() {

        button1.setText(B1);
        button2.setText(B2);
        button3.setText(B3);
        button4.setText(B4);
        button5.setText(B5);
        button6.setText(B6);
        button7.setText(B7);
        button8.setText(B8);
        button9.setText(B9);

        try {
            button1.setText(B1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button2.setText(B2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button3.setText(B3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button4.setText(B4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button5.setText(B5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button6.setText(B6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button7.setText(B7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button8.setText(B8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            button9.setText(B9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** is called when the user clicks the Skip button **/
    /** it causes the generation of a new problem for the user to solve **/
    /** as well as a new random answer for the user to solve **/
    public void Skip(@SuppressWarnings("UnusedParameters") View view) {
        GenerateOperation();
    }

    /** these functions listen for one of the buttons on screen to be clicked **/
    /** they then determine what needs to be displayed the correct or incorrect on screen text **/
    /** then they do so with a delay determined in milliseconds **/
    View.OnClickListener myB1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 0) {
                    C.setEnabled(true);
                    Handler.postDelayed(Correct1, 1750);
                } else {
                    IC.setEnabled(true);
                    Handler.postDelayed(InCorrect1, 1750);
                }
        }
    };
    View.OnClickListener myB2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 1) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 2) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 3) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 4) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 5) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 6) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 7) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };
    View.OnClickListener myB9 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getS1() == 8) {
                C.setEnabled(true);
                Handler.postDelayed(Correct1, 1750);
            } else {
                IC.setEnabled(true);
                Handler.postDelayed(InCorrect1, 1750);
            }
        }
    };

    /** this is called when the user has clicked an correct answer **/
    private Runnable Correct1 = new Runnable() {
        @Override
        public void run() {
            C.setEnabled(false);
            ScoreUpdate();
        }
    };

    /** this is called when the user has clicked an incorrect answer **/
    private Runnable InCorrect1 = new Runnable() {
        @Override
        public void run() {
            IC.setEnabled(false);
            GenerateOperation();
        }
    };

    /** this function updates the score displayed on screen **/
    private void ScoreUpdate() {
        setScore(getScore()+1);
        S.setText(Integer.toString(getScore()));
        GenerateOperation();
    }

}