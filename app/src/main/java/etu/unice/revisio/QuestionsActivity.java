package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        File files = getIntent().getExtras().getParcelable(Application.FILES);

        TextView label = findViewById(R.id.label);
        TextView answer = findViewById(R.id.answer);
        TextView answer1 = findViewById(R.id.answer1);
        RadioButton btn1 = findViewById(R.id.btn1);
        RadioButton btn2 = findViewById(R.id.btn2);
        RadioButton btn3 = findViewById(R.id.btn3);
        Button validate = findViewById(R.id.validate);
        Button lastValidate = findViewById(R.id.lastValidate);
        final String[] getAnswer = new String[1];
        final String[] a1 = new String[1];
        final String[] a2 = new String[1];
        final String[] a3 = new String[1];

        label.setText(files.getName());

        answer1.setText(files.getQuestions().get(0).getLabel());
        btn1.setText(files.getQuestions().get(0).getAnswer1());
        btn2.setText(files.getQuestions().get(0).getAnswer2());
        btn3.setText(files.getQuestions().get(0).getAnswer3());

        int i = 0;

        validate.setOnClickListener(view -> {
            if(btn1.isChecked()) {
                getAnswer[0] = btn1.getText().toString();
                btn1.setChecked(false);
            }

            else if(btn2.isChecked()) {
                //getAnswer[0] = btn2.getText().toString();
                btn2.setChecked(false);
            }

            else if(btn3.isChecked()) {
                getAnswer[0] = btn3.getText().toString();
                btn3.setChecked(false);
            }

            a1[0] = getAnswer[0];
            //answer.setText(a1[0]);

            answer1.setText(files.getQuestions().get(i).getLabel());
            btn1.setText(files.getQuestions().get(i).getAnswer1());
            btn2.setText(files.getQuestions().get(i).getAnswer2());
            btn3.setText(files.getQuestions().get(i).getAnswer3());
        });

        lastValidate.setOnClickListener(view -> {
            Intent intent = new Intent(QuestionsActivity.this, QuestionActivity_2.class);
            startActivity(intent);
        });

    }
}