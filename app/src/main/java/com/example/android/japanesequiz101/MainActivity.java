package com.example.android.japanesequiz101;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String question1 = "";

    boolean question2Answer1 = false;
    boolean question2Answer2 = false;
    boolean question2Answer3 = false;
    boolean question2Answer4 = false;

    String question3 = "";
    String question4 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        CheckBox checkBox;
        switch (view.getId()) {
            case R.id.question2_answer1:
                checkBox = (CheckBox) findViewById(R.id.question2_answer1);
                if (checkBox.isChecked()) {
                    question2Answer1 = true;
                } else {
                    question2Answer1 = false;
                }
                break;
            case R.id.question2_answer2:
                checkBox = (CheckBox) findViewById(R.id.question2_answer2);
                if (checkBox.isChecked()) {
                    question2Answer2 = true;
                } else {
                    question2Answer2 = false;
                }
                break;
            case R.id.question2_answer3:
                checkBox = (CheckBox) findViewById(R.id.question2_answer3);
                if (checkBox.isChecked()) {
                    question2Answer3 = true;
                } else {
                    question2Answer3 = false;
                }
                break;
            case R.id.question2_answer4:
                checkBox = (CheckBox) findViewById(R.id.question2_answer4);
                if (checkBox.isChecked()) {
                    question2Answer4 = true;
                } else {
                    question2Answer4 = false;
                }
                break;
            case R.id.question3_radio1:
                question3 = getString(R.string.question3answer1);
                break;
            case R.id.question3_radio2:
                question3 = getString(R.string.question3answer2);
                break;
            case R.id.question3_radio3:
                question3 = getString(R.string.question3answer3);
                break;
        }
    }

    public void completeTest(View view) {
        int score = 0;

        EditText question1Answer = (EditText) findViewById(R.id.question1_edit_text);
        EditText question4Answer = (EditText) findViewById(R.id.question4_edit_text);
        question1 = question1Answer.getText().toString().toLowerCase();
        question4 = question4Answer.getText().toString().toLowerCase();

        if (question1.contains("desu")) {
            score += 1;
        }

        if (question2Answer1 == true && question2Answer2 == false && question2Answer3 == true && question2Answer4 == false) {
            score += 1;
        }

        if (question3 == getText(R.string.question3answer2)) {
            score += 1;
        }

        if (question4.equalsIgnoreCase("nana")) {
            score += 1;
        }

        System.out.println(score);

        showResults(score);
        clearAnswers();
    }

    private void showResults(int score) {
        Context context = getApplicationContext();
        String result1 = getText(R.string.result1).toString();
        String result2 = getText(R.string.result2).toString();
        int maxQuestions = Integer.parseInt(getText(R.string.numberOfQuestions).toString());
        String toastString = result1 + " " + score + " " + result2 + " " + maxQuestions + "\n";
        int duration = Toast.LENGTH_LONG;

        toastString = toastString + "Nice Job!";

        Toast toast = Toast.makeText(context, toastString, duration);
        toast.show();
    }

    public void clearAnswers() {
        EditText question1Answer = (EditText) findViewById(R.id.question1_edit_text);
        EditText question4Answer = (EditText) findViewById(R.id.question4_edit_text);
        question1Answer.getText().clear();
        question1 = "";
        question4Answer.getText().clear();
        question4 = "";

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question2_answer1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question2_answer2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question2_answer3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.question2_answer4);
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        question2Answer1 = false;
        question2Answer2 = false;
        question2Answer3 = false;
        question2Answer4 = false;

        RadioButton radio1 = (RadioButton) findViewById(R.id.question3_radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.question3_radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.question3_radio3);
        radio1.setChecked(false);
        radio2.setChecked(false);
        radio3.setChecked(false);
        question3 = "";
    }

}
