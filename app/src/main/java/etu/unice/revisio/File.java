package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class File extends AppCompatActivity {
    private String name;
    private int color;
    private ArrayList<Questions> questions;

    public File(String name, int color, ArrayList<Questions> questions) {
        this.name = name;
        this.color = color;
        this.questions = questions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        Button addFiles = findViewById(R.id.addFiles);

        addFiles.setOnClickListener(view -> {
            Intent add = new Intent(getApplicationContext(), EditFiles.class);
            startActivity(add);
        });

    }
}
