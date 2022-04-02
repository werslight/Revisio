package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ImageButton settings = findViewById(R.id.settings);
        Button calendar = findViewById(R.id.calendarStudyB);
        Button startStudy = findViewById(R.id.startStudyB);
        Button editStudy = findViewById(R.id.editStudyB);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settings = new Intent(getApplicationContext(), Settings.class);
                startActivity(settings);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendar = new Intent(getApplicationContext(), Calendar.class);
                startActivity(calendar);
            }
        });

        startStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startStudy = new Intent(getApplicationContext(), StartReviews.class);
                startActivity(startStudy);
            }
        });

        editStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editStudy = new Intent(getApplicationContext(), SeeFiles.class);
                startActivity(editStudy);
            }
        });
    }
}