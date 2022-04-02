package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ImageButton settings = findViewById(R.id.settings);
        Button calendar = findViewById(R.id.calendarStudyB);
        Button startStudy = findViewById(R.id.startStudyB);
        Button editStudy = findViewById(R.id.editStudyB);

        settings.setOnClickListener(view -> {
            Intent settings1 = new Intent(getApplicationContext(), Settings.class);
            startActivity(settings1);
        });

        calendar.setOnClickListener(view -> {
            Intent calendar1 = new Intent(getApplicationContext(), Calendar.class);
            startActivity(calendar1);
        });

        startStudy.setOnClickListener(view -> {
            Intent startStudy1 = new Intent(getApplicationContext(), StartReviews.class);
            startActivity(startStudy1);
        });

        editStudy.setOnClickListener(view -> {
            Intent editStudy1 = new Intent(getApplicationContext(), Category.class);
            startActivity(editStudy1);
        });
    }
}