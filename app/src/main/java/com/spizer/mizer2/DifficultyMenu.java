package com.spizer.mizer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.View;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class DifficultyMenu extends AppCompatActivity {

    /** calls to make the class ProblemSelector usable in this class **/
    @SuppressWarnings("unused")
    private ProblemSelector PS = new ProblemSelector();

    public boolean AChecked;
    public boolean SChecked;
    public boolean MChecked;
    public boolean DChecked;

    public boolean AddP = PS.AddProb;
    public boolean SubP = PS.SubProb;
    public boolean MultiP = PS.MultiProb;
    public boolean DivisP = PS.DivisProb;

    public int ANum = PS.ANum;
    public int SNum = PS.SNum;
    public int MNum = PS.MNum;
    public int DNum = PS.DNum;

    private int T1;
    private int T2;
    private int T3;
    private int T4;

    public int AD;
    public int SD;
    public int MD;
    public int DD;

    @SuppressWarnings("unused")
    private int AddDiff;
    @SuppressWarnings("unused")
    public int SubDiff;
    @SuppressWarnings("unused")
    public int MultiDiff;
    @SuppressWarnings("unused")
    public int DivisDiff;

    @SuppressWarnings("FieldCanBeLocal")
    private ExpandableListAdapter listAdapter;
    @SuppressWarnings("FieldCanBeLocal")
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        String S1 = String.valueOf(PS.AddP);
//        Log.d("DifficultyMenu.java", S1);

        String S11 = String.valueOf(AddP);
        Log.d("DifficultyMenu.java", S11);

//        String S2 = String.valueOf(PS.SubP);
//        Log.d("DifficultyMenu.java", S2);

        String S22 = String.valueOf(SubP);
        Log.d("DifficultyMenu.java", S22);

//        String S3 = String.valueOf(PS.MultiP);
//        Log.d("DifficultyMenu.java", S3);

        String S33 = String.valueOf(MultiP);
        Log.d("DifficultyMenu.java", S33);

//        String S4 = String.valueOf(PS.DivisP);
//        Log.d("DifficultyMenu.java", S4);

        String S44 = String.valueOf(DivisP);
        Log.d("DifficultyMenu.java", S44);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_menu);

        // get the list view
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // List view Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // List view Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // List view Group collapsed listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // List view on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();
                /** converts the selected number in the expandable list to a usable integer variable **/
                /** also detects if a Difficulty has been selected for each for of problem to practice **/
                /** also gives an error to debug console level if something unexpected has happened **/
                if (listDataHeader.get(groupPosition).equals("AdditionDifficulty")) {
                    AChecked = true;
                    getApplicationContext();
                    String St1 = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                    Log.d("DifficultyMenu.java", "Line: 159 : " + St1);
                    AD = Integer.parseInt(St1);
                    Log.d("DifficultyMenu.java", "Line: 161 : " + AD);
                } else if (listDataHeader.get(groupPosition).equals("SubtractionDifficulty")) {
                    SChecked = true;
                    getApplicationContext();
                    String St2 = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                    Log.d("DifficultyMenu.java", "Line: 166 : " + St2);
                    SD = Integer.parseInt(St2);
                } else if (listDataHeader.get(groupPosition).equals("MultiplicationDifficulty")) {
                    MChecked = true;
                    getApplicationContext();
                    String St3 = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                    Log.d("DifficultyMenu.java", "Line: 172 : " + St3);
                    MD = Integer.parseInt(St3);
                } else if (listDataHeader.get(groupPosition).equals("DivisionDifficulty")) {
                    DChecked = true;
                    getApplicationContext();
                    String St4 = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                    Log.d("DifficultyMenu.java", "Line: 178 : " + St4);
                    DD = Integer.parseInt(St4);
                } else {
                    Log.e("DifficultyMenu.java", "could not parse a group position when user selected a field");
                }
                //noinspection LoopStatementThatDoesntLoop
                while (true) {
                    /** determines if a difficulty has been selected for each of the math operations the user choose to practice **/
                    if (AddP && AChecked && !SubP && !MultiP && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 181");
                        WF();
                        break;
                    } else if (!AddP && SubP && SChecked && !MultiP && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 184");
                        WF();
                        break;
                    } else if (!AddP && !SubP && MultiP && MChecked && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 187");
                        WF();
                        break;
                    } else if (!AddP && !SubP && !MultiP && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 190");
                        WF();
                        break;
                    } else if (AddP && AChecked && SubP && SChecked && !MultiP && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 193");
                        WF();
                        break;
                    } else if (AddP && AChecked && !SubP && MultiP && MChecked && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 196");
                        WF();
                        break;
                    } else if (AddP && AChecked && !SubP && !MultiP && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 199");
                        WF();
                        break;
                    } else if (!AddP && SubP && SChecked && MultiP && MChecked && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 202");
                        WF();
                        break;
                    } else if (!AddP && SubP && SChecked && !MultiP && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 205");
                        WF();
                        break;
                    } else if (!AddP && !SubP && MultiP && MChecked && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 208");
                        WF();
                        break;
                    } else if (AddP && AChecked && SubP && SChecked && MultiP && MChecked && !DivisP) {
                        Log.d("DifficultyMenu.java", "Success! Line: 211");
                        WF();
                        break;
                    } else if (AddP && AChecked && SubP && SChecked && !MultiP && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 214");
                        WF();
                        break;
                    } else if (AddP && AChecked && !SubP && MultiP && MChecked && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 217");
                        WF();
                        break;
                    } else if (!AddP && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 220");
                        WF();
                        break;
                    } else if (AddP && AChecked && SubP && SChecked && MultiP && MChecked && DivisP && DChecked) {
                        Log.d("DifficultyMenu.java", "Success! Line: 223");
                        WF();
                        break;
                    } else {
                        Log.e("DifficultyMenu.java", "Something went horribly wrong at line: 225");
                        break;
                    }
                }
                return true;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        if(AddP) { listDataHeader.add("AdditionDifficulty"); }
        if(SubP) { listDataHeader.add("SubtractionDifficulty"); }
        if(MultiP) { listDataHeader.add("MultiplicationDifficulty"); }
        if(DivisP) { listDataHeader.add("DivisionDifficulty"); }
        System.out.println(listDataHeader);
        /** this removes fields that the user has not selected to practice **/
//        if(!PS.AddProb) { listDataHeader.remove("AdditionDifficulty"); }
//        if(!PS.SubProb) { listDataHeader.remove("SubtractionDifficulty"); }
//        if(!PS.MultiProb) { listDataHeader.remove("MultiplicationDifficulty"); }
//        if(!PS.DivisProb) { listDataHeader.remove("DivisionDifficulty"); }

        // Adding child data
        List<String> AdditionDifficulty = new ArrayList<>();
        while (true) {
            if (T1 < 11) {
                String S1 = Integer.toString(T1);
                AdditionDifficulty.add(S1);
                T1++;
            } else {
                break;
            }
        }

        List<String> SubtractionDifficulty = new ArrayList<>();
        while (true) {
            if (T2 < 11) {
                String S2 = Integer.toString(T2);
                SubtractionDifficulty.add(S2);
                T2++;
            } else {
                break;
            }
        }

        List<String> MultiplicationDifficulty = new ArrayList<>();
        while (true) {
            if (T3 < 11) {
                String S3 = Integer.toString(T3);
                MultiplicationDifficulty.add(S3);
                T3++;
            } else {
                break;
            }
        }

        List<String> DivisionDifficulty = new ArrayList<>();
        while (true) {
            if (T4 < 11) {
                String S4 = Integer.toString(T4);
                DivisionDifficulty.add(S4);
                T4++;
            } else {
                break;
            }
        }

        /** this draws out the Expandable lists **/
        if(AddP) {
            listDataChild.put(listDataHeader.get(ANum), AdditionDifficulty);
        } else {
            Log.d("DifficultyMenu.java","Something went wrong at line: 230");
        }
        if(SubP) {
            listDataChild.put(listDataHeader.get(SNum), SubtractionDifficulty);
        } else {
            Log.d("DifficultyMenu.java","Something went wrong at line: 231");
        }
        if(MultiP) {
            listDataChild.put(listDataHeader.get(MNum), MultiplicationDifficulty);
        } else {Log.d("DifficultyMenu.java","Something went wrong at line: 232");
        }

        if(DivisP) {
            listDataChild.put(listDataHeader.get(DNum), DivisionDifficulty);
        } else {Log.d("DifficultyMenu.java","Something went wrong at line: 233");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_difficulty_menu, menu);
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

    /** called once the user has selected a difficulty for each of the math operations to practice **/
    private void WF() {
        Intent WhenFinished = new Intent(this, BasicsPractice.class);
        startActivity(WhenFinished);
    }
}