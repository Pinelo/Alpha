package com.example.rogelio.saludtec;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class reporteSemaforo extends AppCompatActivity {

    private ProgressBar foodReportPB;
    private ProgressBar fitReportPB;
    private List<ProgressBar> foodProgressBars = new ArrayList<>();
    private List<TextView> foodCriteriaTVs = new ArrayList<>();
    private List<TextView> foodGradeTVs = new ArrayList<>();

    private int[] foodProgressReports;

    private int fitReportProgress = 0;
    private int foodReportProgress = 0;
    private DbOperations dbo;
    String criterias[];
    TextView nutritionScoreTV;
    TextView fitScoreTV;
    String yellowHex = "#FFD041";
    String greenHex = "#239481";
    String blueHex = "#2F9DC4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_semaforo);
        Resources resources = getApplicationContext().getResources();
        criterias = resources.getStringArray(R.array.textCut);

        dbo = new DbOperations(this);
        nutritionScoreTV = (TextView)findViewById(R.id.nutritionReportScoreTV);
        fitScoreTV = (TextView)findViewById(R.id.fitnessReportScoreTV);
        foodReportPB = (ProgressBar) findViewById(R.id.foodReportPB);
        fitReportPB = (ProgressBar) findViewById(R.id.fitnessReportPB);

        updateScores();


    }

    private void updateScores() {

        foodReportProgress = dbo.getNutritionScore();
        fitReportProgress = 43;

        foodReportPB.setProgress(foodReportProgress);
        fitReportPB.setProgress(fitReportProgress);

        String foodReportProgressString = Integer.toString(foodReportProgress) + "%";
        nutritionScoreTV.setText(foodReportProgressString);

        String fitnessReportProgressString = Integer.toString(fitReportProgress) + "%";
        fitScoreTV.setText(fitnessReportProgressString);

//        setProgressBarColor(fitReportPB, fitReportProgress);
//        setProgressBarColor(foodReportPB, foodReportProgress);

        foodProgressBars = getFoodProgressBars();
        foodCriteriaTVs = getFoodCriteriaTV();
        foodGradeTVs = getFoodGradeTV();
        int[] foodCriteriaAverages = dbo.getNutritionAverages();
        setUpViews(foodCriteriaAverages, foodProgressBars, foodCriteriaTVs, foodGradeTVs);





    }

    private void setUpViews(int[] foodCriteriaAverages, List<ProgressBar> foodProgressBars, List<TextView> foodCriteriaTVs, List<TextView> foodGradeTVs) {
        int i;

        for(i = 0; i < foodCriteriaAverages.length; i++) {

            int progess = foodCriteriaAverages[i];
            foodProgressBars.get(i).setProgress(progess);
            setProgressBarColor(foodProgressBars.get(i), progess);
            foodCriteriaTVs.get(i).setText(criterias[i]);
            foodGradeTVs.get(i).setText(Integer.toString(progess) + "%");
        }
    }

    private void setProgressBarColor(ProgressBar progressBar, int progress) {
        if (progress < 50) {
            progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        } else if (progress < 80) {
            progressBar.getProgressDrawable().setColorFilter(Color.parseColor(yellowHex), PorterDuff.Mode.SRC_IN);
        } else {
            progressBar.getProgressDrawable().setColorFilter(Color.parseColor(greenHex), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateScores();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reporte_semaforo, menu);
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

    private List<ProgressBar> getFoodProgressBars() {
        List<ProgressBar> list = new ArrayList<>();

        ProgressBar pB1 = (ProgressBar)findViewById(R.id.criteriaOnePB);
        list.add(pB1);

        ProgressBar pB2 = (ProgressBar)findViewById(R.id.criteriaTwoPB);
        list.add(pB2);

        ProgressBar pB3 = (ProgressBar)findViewById(R.id.criteriaThreePB);
        list.add(pB3);

        ProgressBar pB4 = (ProgressBar)findViewById(R.id.criteriaFourPB);
        list.add(pB4);

        ProgressBar pB5 = (ProgressBar)findViewById(R.id.criteriaFivePB);
        list.add(pB5);

        ProgressBar pB6 = (ProgressBar)findViewById(R.id.criteriaSixPB);
        list.add(pB6);

        ProgressBar pB7 = (ProgressBar)findViewById(R.id.criteriaSevenPB);
        list.add(pB7);

        ProgressBar pB8 = (ProgressBar)findViewById(R.id.criteriaEightPB);
        list.add(pB8);

        ProgressBar pB9 = (ProgressBar)findViewById(R.id.criteriaNinePB);
        list.add(pB9);

        ProgressBar pB10 = (ProgressBar)findViewById(R.id.criteriaTenPB);
        list.add(pB10);

        return list;
    }

    private List<TextView> getFoodCriteriaTV() {
        List<TextView> list = new ArrayList<>();

        TextView tB1 = (TextView)findViewById(R.id.criteriaOneTV);
        list.add(tB1);

        TextView tB2 = (TextView)findViewById(R.id.criteriaTwoTV);
        list.add(tB2);

        TextView tB3 = (TextView)findViewById(R.id.criteriaThreeTV);
        list.add(tB3);

        TextView tB4 = (TextView)findViewById(R.id.criteriaFourTV);
        list.add(tB4);

        TextView tB5 = (TextView)findViewById(R.id.criteriaFiveTV);
        list.add(tB5);

        TextView tB6 = (TextView)findViewById(R.id.criteriaSixTV);
        list.add(tB6);

        TextView tB7 = (TextView)findViewById(R.id.criteriaSevenTV);
        list.add(tB7);

        TextView tB8 = (TextView)findViewById(R.id.criteriaEightTV);
        list.add(tB8);

        TextView tB9 = (TextView)findViewById(R.id.criteriaNineTV);
        list.add(tB9);

        TextView tB10 = (TextView)findViewById(R.id.criteriaTenTV);
        list.add(tB10);

        return list;
    }

    private List<TextView> getFoodGradeTV() {

        List<TextView> list = new ArrayList<>();

        TextView tB1 = (TextView)findViewById(R.id.criteriaOneGradeTV);
        list.add(tB1);

        TextView tB2 = (TextView)findViewById(R.id.criteriaTwoGradeTV);
        list.add(tB2);

        TextView tB3 = (TextView)findViewById(R.id.criteriaThreeGradeTV);
        list.add(tB3);

        TextView tB4 = (TextView)findViewById(R.id.criteriaFourGradeTV);
        list.add(tB4);

        TextView tB5 = (TextView)findViewById(R.id.criteriaFiveGradeTV);
        list.add(tB5);

        TextView tB6 = (TextView)findViewById(R.id.criteriaSixGradeTV);
        list.add(tB6);

        TextView tB7 = (TextView)findViewById(R.id.criteriaSevenGradeTV);
        list.add(tB7);

        TextView tB8 = (TextView)findViewById(R.id.criteriaEightGradeTV);
        list.add(tB8);

        TextView tB9 = (TextView)findViewById(R.id.criteriaNineGradeTV);
        list.add(tB9);

        TextView tB10 = (TextView)findViewById(R.id.criteriaTenGradeTV);
        list.add(tB10);

        return list;
    }
}
