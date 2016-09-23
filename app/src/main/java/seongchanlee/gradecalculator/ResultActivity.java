package seongchanlee.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView_current = (TextView) findViewById(R.id.textCurrent);
        TextView textView_goal = (TextView) findViewById(R.id.textGoal);
        TextView textView_remaining = (TextView) findViewById(R.id.textWeight);

        Intent intent_01 = getIntent();

        Bundle bundle = getIntent().getExtras();

        float grade1 = bundle.getFloat("Grade1");
        float grade2 = bundle.getFloat("Grade2");
        float grade3 = bundle.getFloat("Grade3");
        float grade4 = bundle.getFloat("Grade4");
        float grade5 = bundle.getFloat("Grade5");

        float weight1 = bundle.getFloat("Weight1");
        float weight2 = bundle.getFloat("Weight2");
        float weight3 = bundle.getFloat("Weight3");
        float weight4 = bundle.getFloat("Weight4");
        float weight5 = bundle.getFloat("Weight5");

        float desired = bundle.getFloat("DesiredGrade");

        float totalWeight = 100.00f;
        float totalWeightSoFar;
        float totalGradeSoFar;
        float totalWeightedGrades;
        float remainingWeight;
        float goalGrade;

        totalWeightSoFar = weight1 + weight2 + weight3 + weight4 + weight5;
        remainingWeight = totalWeight - totalWeightSoFar;

        totalWeightedGrades = (grade1 * weight1) + (grade2 * weight2) + (grade3 * weight3) +
                (grade4 * weight4) + (grade5 * weight5);

        totalGradeSoFar = (((grade1*(weight1/100.00f)) + (grade2*(weight2/100.00f)) +
                (grade3*(weight3/100.00f)) + (grade4*(weight4/100.00f))
                + (grade5*(weight5/100.00f)))/totalWeightSoFar)*100.00f;

        goalGrade = (desired * totalWeight - totalWeightedGrades)/(totalWeight - totalWeightSoFar);

        String goalGradeString = Float.toString(goalGrade);
        String gradeSoFarString = Float.toString(totalGradeSoFar);
        String remaingWeightString = Float.toString(remainingWeight);

        textView_current.setText(String.valueOf(gradeSoFarString));
        textView_goal.setText(String.valueOf(goalGradeString));
        textView_remaining.setText(String.valueOf(remaingWeightString));
    }

    public void onClickBack(View v) {
        finish();
    }
}
