package seongchanlee.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {
    private static float totalWeight = 100.00f;
    private float totalWeightSoFar;
    private float totalGradeSoFar;
    private float totalWeightedGrades;
    private float remainingWeight;
    private float goalGrade;
    private String goalGradeString;
    private String gradeSoFarString;
    private String remainingWeightString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView_current = (TextView) findViewById(R.id.textCurrent);
        TextView textView_goal = (TextView) findViewById(R.id.textGoal);
        TextView textView_remaining = (TextView) findViewById(R.id.textWeight);

        Intent intent_01 = getIntent();
        Bundle bundle = getIntent().getExtras();

        HashMap<String, Float> valueMap = (HashMap<String, Float>)
                intent_01.getSerializableExtra("ValueMap");

        float grade1 = valueMap.get("Grade1");
        float grade2 = valueMap.get("Grade2");
        float grade3 = valueMap.get("Grade3");
        float grade4 = valueMap.get("Grade4");
        float grade5 = valueMap.get("Grade5");

        float weight1 = valueMap.get("Weight1");
        float weight2 = valueMap.get("Weight2");
        float weight3 = valueMap.get("Weight3");
        float weight4 = valueMap.get("Weight4");
        float weight5 = valueMap.get("Weight5");

        float desired = bundle.getFloat("DesiredGrade");

        totalWeightSoFar = weight1 + weight2 + weight3 + weight4 + weight5;
        remainingWeight = totalWeight - totalWeightSoFar;

        totalWeightedGrades = (grade1 * weight1) + (grade2 * weight2) + (grade3 * weight3) +
                (grade4 * weight4) + (grade5 * weight5);

        totalGradeSoFar = (((grade1*(weight1/totalWeight)) + (grade2*(weight2/totalWeight)) +
                (grade3*(weight3/totalWeight)) + (grade4*(weight4/totalWeight))
                + (grade5*(weight5/totalWeight)))/totalWeightSoFar)*totalWeight;

        goalGrade = (desired * totalWeight - totalWeightedGrades)/(totalWeight - totalWeightSoFar);

        goalGradeString = Float.toString(toTwoDecimal(goalGrade));
        gradeSoFarString = Float.toString(toTwoDecimal(totalGradeSoFar));
        remainingWeightString = Float.toString(toTwoDecimal(remainingWeight));

        textView_current.setText(String.valueOf(gradeSoFarString));
        textView_goal.setText(String.valueOf(goalGradeString));
        textView_remaining.setText(String.valueOf(remainingWeightString));
    }

    private float toTwoDecimal(float f) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.CANADA);

        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.HALF_UP);

        Float formattedFloat = new Float(formatter.format(f));

        return formattedFloat;
    }

    public void onClickBack(View v) {
        finish();
    }
}
