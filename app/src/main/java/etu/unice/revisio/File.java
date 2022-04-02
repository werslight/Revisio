package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class File extends AppCompatActivity {
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
