package seongchanlee.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static float emptyFieldFloat = 0.00f;

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

        HashMap<String, Float> valueMap = new HashMap<>();

        valueMap.put("Grade1", editTextToFloat(text_grade1));
        valueMap.put("Grade2", editTextToFloat(text_grade2));
        valueMap.put("Grade3", editTextToFloat(text_grade3));
        valueMap.put("Grade4", editTextToFloat(text_grade4));
        valueMap.put("Grade5", editTextToFloat(text_grade5));

        valueMap.put("Weight1", editTextToFloat(text_weight1));
        valueMap.put("Weight2", editTextToFloat(text_weight2));
        valueMap.put("Weight3", editTextToFloat(text_weight3));
        valueMap.put("Weight4", editTextToFloat(text_weight4));
        valueMap.put("Weight5", editTextToFloat(text_weight5));

        float valDesired;
        if (!TextUtils.isEmpty(text_desired.getText())) {
            valDesired = Float.parseFloat(text_desired.getText().toString());
        } else {
            text_desired.setError("This field cannot be empty.");
            return;
        }

        Intent intent_01 = new Intent(getApplicationContext(), ResultActivity.class);

        intent_01.putExtra("ValueMap", valueMap);
        intent_01.putExtra("DesiredGrade", valDesired);

        startActivity(intent_01);
    }

    private float editTextToFloat(EditText et) {
        if (!TextUtils.isEmpty(et.getText())) {
            return Float.parseFloat(et.getText().toString());
        } else {
            return emptyFieldFloat;
        }
    }
}
