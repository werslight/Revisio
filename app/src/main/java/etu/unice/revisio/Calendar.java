package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Button back = findViewById(R.id.back);
        Button btnBrowser = findViewById(R.id.browser);

        back.setOnClickListener(view -> {
            Intent back1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(back1);
        });

        btnBrowser.setOnClickListener(view -> {
            Intent back12 = new Intent(getApplicationContext(), Browser.class);
            startActivity(back12);
        });

    }
}
