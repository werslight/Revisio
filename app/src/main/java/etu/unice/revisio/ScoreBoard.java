package etu.unice.revisio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ScoreBoard extends AppCompatActivity {
    ImageView starSpinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        starSpinning = findViewById(R.id.stars);
        Animation star = AnimationUtils.loadAnimation(ScoreBoard.this, R.anim.spin_result);
        starSpinning.startAnimation(star);
    }
}