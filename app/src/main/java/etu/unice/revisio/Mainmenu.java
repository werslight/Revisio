package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mainmenu extends AppCompatActivity {

    ImageView logo;
    TextView title;
    Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        logo = findViewById(R.id.appLogo);
        logo.startAnimation(AnimationUtils.loadAnimation(
                this, R.anim.special));

        title = findViewById(R.id.titleMainMenu);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        Mainmenu.this, R.anim.clicked));
                title.setVisibility(View.VISIBLE);
            }
        });

        bt1 = findViewById(R.id.startStudyB);
        bt2 = findViewById(R.id.editStudyB);
        bt3 = findViewById(R.id.calendarStudyB);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        Mainmenu.this, R.anim.clicked));
                bt1.setVisibility(View.VISIBLE);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        Mainmenu.this, R.anim.clicked));
                bt2.setVisibility(View.VISIBLE);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        Mainmenu.this, R.anim.clicked));
                bt3.setVisibility(View.VISIBLE);
            }
        });


    }
}