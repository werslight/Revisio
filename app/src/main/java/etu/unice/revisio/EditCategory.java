package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class EditCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_edit);


        Button btnValidate = findViewById(R.id.btnValidate);
        ImageButton back = findViewById(R.id.back);

        btnValidate.setOnClickListener(view -> {
            Intent validate = new Intent(getApplicationContext(), File.class);
            startActivity(validate);
        });

        back.setOnClickListener(view -> {
            Intent back1 = new Intent(getApplicationContext(), Category.class);
            startActivity(back1);
        });
    }
}