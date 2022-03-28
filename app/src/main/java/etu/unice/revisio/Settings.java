package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Settings extends AppCompatActivity {
    int i = 0, j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNotif = findViewById(R.id.btnNotif);
        Button btnEffect = findViewById(R.id.btnEffect);
        ImageView imgNotif = findViewById(R.id.imgNotif);
        ImageView imgEffect = findViewById(R.id.imgEffect);

        int [] arrayNotif = {R.drawable.notif_off,
                R.drawable.notif_on};

        int [] arrayEffect = {R.drawable.sound_off,
                R.drawable.sound_on};

        btnNotif.setOnClickListener(view -> {
            imgNotif.setImageResource(arrayNotif[i]);
            i++;
            if(i == 2) {
                i = 0;
            }
        });

        btnEffect.setOnClickListener(view -> {
            imgEffect.setImageResource(arrayEffect[j]);
            j++;
            if(j == 2) {
                j = 0;
            }
        });
    }
}