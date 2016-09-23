package seongchanlee.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalculate(View v) {

        EditText text_grade1 = (EditText) findViewById(R.id.Grade1);
        EditText text_grade2 = (EditText) findViewById(R.id.Grade2);
        EditText text_grade3 = (EditText) findViewById(R.id.Grade3);
        EditText text_grade4 = (EditText) findViewById(R.id.Grade4);
        EditText text_grade5 = (EditText) findViewById(R.id.Grade5);

        EditText text_weight1 = (EditText) findViewById(R.id.Weight1);
        EditText text_weight2 = (EditText) findViewById(R.id.Weight2);
        EditText text_weight3 = (EditText) findViewById(R.id.Weight3);
        EditText text_weight4 = (EditText) findViewById(R.id.Weight4);
        EditText text_weight5 = (EditText) findViewById(R.id.Weight5);

        EditText text_desired = (EditText) findViewById(R.id.desiredGrade);

        float valGrade1;
        if (!TextUtils.isEmpty(text_grade1.getText())) {
            valGrade1 = Float.parseFloat(text_grade1.getText().toString());
        } else {
            valGrade1 = 0.00f;
        }

        float valGrade2;
        if (!TextUtils.isEmpty(text_grade2.getText())) {
            valGrade2 = Float.parseFloat(text_grade2.getText().toString());
        } else {
            valGrade2 = 0.00f;
        }

        float valGrade3;
        if (!TextUtils.isEmpty(text_grade3.getText())) {
            valGrade3 = Float.parseFloat(text_grade3.getText().toString());
        } else {
            valGrade3 = 0.00f;
        }

        float valGrade4;
        if (!TextUtils.isEmpty(text_grade4.getText())) {
            valGrade4 = Float.parseFloat(text_grade4.getText().toString());
        } else {
            valGrade4 = 0.00f;
        }

        float valGrade5;
        if (!TextUtils.isEmpty(text_grade5.getText())) {
            valGrade5 = Float.parseFloat(text_grade5.getText().toString());
        } else {
            valGrade5 = 0.00f;
        }

        float valWeight1;
        if (!TextUtils.isEmpty(text_weight1.getText())) {
            valWeight1 = Float.parseFloat(text_weight1.getText().toString());
        } else {
            valWeight1 = 0.00f;
        }

        float valWeight2;
        if (!TextUtils.isEmpty(text_weight2.getText())) {
            valWeight2 = Float.parseFloat(text_weight2.getText().toString());
        } else {
            valWeight2 = 0.00f;
        }

        float valWeight3;
        if (!TextUtils.isEmpty(text_weight3.getText())) {
            valWeight3 = Float.parseFloat(text_weight3.getText().toString());
        } else {
            valWeight3 = 0.00f;
        }

        float valWeight4;
        if (!TextUtils.isEmpty(text_weight4.getText())) {
            valWeight4 = Float.parseFloat(text_weight4.getText().toString());
        } else {
            valWeight4 = 0.00f;
        }

        float valWeight5;
        if (!TextUtils.isEmpty(text_weight5.getText())) {
            valWeight5 = Float.parseFloat(text_weight5.getText().toString());
        } else {
            valWeight5 = 0.00f;
        }

        float valDesired;
        if (!TextUtils.isEmpty(text_desired.getText())) {
            valDesired = Float.parseFloat(text_desired.getText().toString());
        } else {
            text_desired.setError("This field cannot be empty.");
            return;
        }

        Intent intent_01 = new Intent(getApplicationContext(), ResultActivity.class);

        intent_01.putExtra("Grade1", valGrade1);
        intent_01.putExtra("Grade2", valGrade2);
        intent_01.putExtra("Grade3", valGrade3);
        intent_01.putExtra("Grade4", valGrade4);
        intent_01.putExtra("Grade5", valGrade5);

        intent_01.putExtra("Weight1", valWeight1);
        intent_01.putExtra("Weight2", valWeight2);
        intent_01.putExtra("Weight3", valWeight3);
        intent_01.putExtra("Weight4", valWeight4);
        intent_01.putExtra("Weight5", valWeight5);

        intent_01.putExtra("DesiredGrade", valDesired);

        startActivity(intent_01);
    }
}
