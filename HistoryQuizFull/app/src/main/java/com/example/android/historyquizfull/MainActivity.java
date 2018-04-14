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

import java.security.acl.Group;
import java.util.Objects;

import static android.R.attr.button;
import static android.R.attr.duration;
import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    // TODO 1.1: Declaram doua variabile String in care vom pastra rezultatele.(correctRes si wrongRes)
    String correctResult, wrongResult;
    // TODO 1.2: Creem doua obiecte de tip textView unde vom afisa rezultatele salvate ca string-uri
    // in variabilele de mai sus
    TextView correctResultView, wrongResultView;
    // TODO 1.3: Creem o variabila in care salvam scorul utilizatorului (numarul de raspunsuri corecte)
    int score;

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
        // Urmeaza partea de verificare a raspunsurilor si inregistrarea lor in correctResView
        // si wrongResView

        // PENTRU FIECARE INTREBARE CU CHECKBOX-URI DIN QUIZ
        //
        // Apelam o functie checkBox(), inca nedefinita, care returneaza true daca
        // utilizatorul a raspuns corect la intrebare si false altfel
        // Parametrii functiei sunt urmatorii:
        //      int - id-ul din xml al primului checkbox asociat intrebarii
        //      boolean - raspunsul corect la intrebare: true daca checkbox-ul trebuie bifat si false altfel
        //      int - id-ul din xml al celui de-al 2lea checkbox asociat intrebarii
        //      boolean - raspunsul corect la intrebare: true daca checkbox-ul trebuie bifat si false altfel
        //      int - id-ul din xml al celui de-al 3lea checkbox asociat intrebarii
        //      boolean - raspunsul corect la intrebare: true daca checkbox-ul trebuie bifat si false altfel
        //      int - id-ul din xml al celui de-al 4lea checkbox asociat intrebarii
        //      boolean - raspunsul corect la intrebare: true daca checkbox-ul trebuie bifat si false altfel
        boolean answer1 = checkBox(R.id.franta, true, R.id.polonia, true, R.id.germania, false, R.id.anglia, true);

        // Apelam o functie checkAnswer() care returneaza true daca
        // utilizatorul a raspuns corect la intrebare si false altfel
        // Parametrii functiei sunt urmatorii:
        //      boolean - raspunsul dat de utilizator, cel determinat anterior
        //      string - numarul intrebarii
        //      string - solutia completa la intrebare: optiune1, optiune2, optiune3. Lowercase.
        checkAnswer(answer1, "1", "franta, polonia, regatul unit al marii britanii si irlandei de nord");

        // PENTRU FIECARE INTREBARE CU RADIO BUTTONS-URI DIN QUIZ
        //
        // Apelam o functie checkRadio(), care returneaza true daca
        // utilizatorul a raspuns corect la intrebare si false altfel
        // Parametrii functiei sunt urmatorii:
        //      int - id-ul din xml al grupului de radio din xml
        //      string - raspunsul corect la intrebare
        boolean answer2 = checkRadio(R.id.domnii, "3");

        // Apelam aceeasi functie checkAnswer dar cu alti parametrii, corespunzatori intrebarii 2
        checkAnswer(answer2, "2", "3");

        // PENTRU FIECARE INTREBARE CU EDIT TEXT-URI DIN QUIZ
        //
        // Apelam o functie checkText(), care returneaza true daca
        // utilizatorul a raspuns corect la intrebare si false altfel
        // Parametrii functiei sunt urmatorii:
        //      int - id-ul din xml al grupului de radio din xml
        //      string - raspunsul corect la intrebare
        boolean answer3 = checkText(R.id.traian, "traian");

        // Apelam aceeasi functie checkAnswer dar cu alti parametrii, corespunzatori intrebarii 3
        checkAnswer(answer3, "3", "traian");

        // TODO 2: Actualizam lista cu raspunsuri corecte si gresite de la final, apeland setText() pe view-uri
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

        // TODO 3.1: Se obtin valorile introduse de user in checkbox-uri apeland functia getOptions()
        option2 = getOptions(idb);
        option3 = getOptions(idc);
        option4 = getOptions(idd);

        // TODO 3.2: Verificam daca toate optiunile corespund cu raspunsurile corecte date ca parametrii
        // si se returneaza true daca aceasta conditie e indeplinita (utilizatorul a raspuns corect la intrebare)
        return option1 == a && option2 == b && option3 == c && option4 == d;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean checkRadio(int id, String solution) {
        RadioGroup radioGroup = findViewById(id);
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            return false;
        }

        // TODO 4.1: Se obtine id-ul butonului care a fost selectat de utilizator apeland
        // getCheckedRadioButtonId() pe radioGroup
        int selectedID = radioGroup.getCheckedRadioButtonId();

        // TODO 4.2: Se salveaza butonul cu id-ul obtinut anterior intr-un obiect RadioButton
        // folosind findViewById()
        RadioButton button = findViewById(selectedID);

        // TODO 4.3: Se obtine valoarea text din cadrul butonului apeland getText() pe butonul de mai sus.
        CharSequence text = button.getText();

        return Objects.equals(text.toString().toLowerCase(), solution);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean checkText(int id, String solution) {
        // TODO 5: Se obtine valoarea text din cadrul EditText-ului apeland getText()
        // pe elementul pe care il gasim cu ajutorul id-ului dat ca parametru.
        CharSequence text = ((TextView) findViewById(id)).getText();
        return Objects.equals(text.toString().toLowerCase(), solution);
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