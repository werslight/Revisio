package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        File files = getIntent().getExtras().getParcelable(Application.FILES);

        TextView label = findViewById(R.id.label);
        TextView answer1 = findViewById(R.id.answer1);
        //ListView displayList = findViewById(R.id.listViewAnswer);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        List answer = new ArrayList();

        label.setText(files.getName());

        answer1.setText(files.getQuestions().get(0).getLabel());
        btn1.setText(files.getQuestions().get(0).getAnswer1());
        btn2.setText(files.getQuestions().get(0).getAnswer2());
        btn3.setText(files.getQuestions().get(0).getAnswer3());

        /*ArrayAdapter arrayAdapterAnswer = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1 , answer);
        displayList.setAdapter(arrayAdapterAnswer);*/
    }
}