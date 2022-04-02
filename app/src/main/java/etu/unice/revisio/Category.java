package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Category extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button addCategory = findViewById(R.id.addCategory);
        ImageButton back = findViewById(R.id.back);

        addCategory.setOnClickListener(view -> {
            Intent add = new Intent(getApplicationContext(), EditCategory.class);
            startActivity(add);
        });

        back.setOnClickListener(view -> {
            Intent back1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(back1);
        });
    }
}
