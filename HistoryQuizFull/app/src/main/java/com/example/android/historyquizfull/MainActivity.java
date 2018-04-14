package com.example.android.historyquizfull;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.historyquizfull.R;

import java.util.Objects;

import static android.R.attr.button;
import static android.R.attr.duration;
import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    int score;
    // TODO 1.1: Declaram doua variabile String in care vom pastra rezultatele.(correctRes si wrongRes)
    String correctResult, wrongResult;
    // TODO 1.2: Creem doua obiecte de tip textView unde vom afisa rezultatele salvate ca string-uri
    // in variabilele de mai sus
    TextView correctResultView, wrongResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 1.3: Asignam fiecarui textView elementul XML corespunzator cu ajutorul
        // metodei findViewById()
        correctResultView = findViewById(R.id.correctResults);
        wrongResultView = findViewById(R.id.wrongResults);

        correctResult = correctResultView.getText().toString();
        wrongResult = correctResultView.getText().toString();

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("savedScore");
            correctResult = savedInstanceState.getString("savedCorrect");
            wrongResult = savedInstanceState.getString("savedWrong");

            correctResultView.setText(correctResult);
            wrongResultView.setText(wrongResult);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("savedScore", score);
        savedInstanceState.putString("savedCorrect", correctResult);
        savedInstanceState.putString("savedWrong", wrongResult);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void submit(View view) {
        
        score = 0;
        correctResult = "CORRECT ANSWERS\n";
        wrongResult = "INCORRECT ANSWERS\n";
        boolean answer1 = checkBox(R.id.franta, true, R.id.polonia, true, R.id.germania, false, R.id.anglia, true);
        checkAnswer(answer1, "1", "franta, polonia, regatul unit al marii britanii si irlandei de nord");

        boolean answer2 = checkRadio(R.id.domnii, "3");
        checkAnswer(answer2, "2", "3");

        boolean answer3 = checkText(R.id.traian, "traian");
        checkAnswer(answer3, "3", "traian");

        correctResultView.setText(correctResult);
        wrongResultView.setText(wrongResult);

        Toast toast = Toast.makeText(getApplicationContext(), "You scored " + score + " out of 10!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public boolean getOptions(int idName) {
        CheckBox c = (CheckBox) findViewById(idName);
        return c.isChecked();
    }

    public boolean checkBox(int ida, boolean a, int idb, boolean b, int idc, boolean c, int idd, boolean d) {
        boolean option1, option2, option3, option4;
        option1 = getOptions(ida);
        option2 = getOptions(idb);
        option3 = getOptions(idc);
        option4 = getOptions(idd);
        return option1 == a && option2 == b && option3 == c && option4 == d;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean checkRadio(int id, String solution) {
        RadioGroup fruitGroup = findViewById(id);
        if (fruitGroup.getCheckedRadioButtonId() == -1) {
            return false;
        }
        int selectedID = fruitGroup.getCheckedRadioButtonId();
        RadioButton button = findViewById(selectedID);
        String text = button.getText().toString().toLowerCase();
        return Objects.equals(text, solution);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean checkText(int id, String solution) {
        String text = ((TextView) findViewById(id)).getText().toString().toLowerCase();
        return Objects.equals(text, solution);
    }

    public void checkAnswer(boolean ans, String i, String solution) {
        if (ans) {
            correctResult += i + ". Correct\n";
            score++;
        } else {
            wrongResult += i + ". Incorrect(S: " + solution + ")\n";
        }
    }
}