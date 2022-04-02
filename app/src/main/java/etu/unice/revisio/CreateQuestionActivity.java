package etu.unice.revisio;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateQuestionActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private CreateQuestionActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.activity = this;
        ListView listView = (ListView)findViewById(R.id.list_categorie);

        //creating categories for testing
        Reponses reponse1 = new Reponses(R.id.remove, R.id.answerEdit);
        Reponses reponse2 = new Reponses(R.id.remove, R.id.answerEdit);
        Reponses reponse3 = new Reponses(R.id.remove, R.id.answerEdit);


        Reponses[] users = new Reponses[]{reponse1,reponse2, reponse3};

        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<Reponses> arrayAdapter
                = new ArrayAdapter<Reponses>(this, android.R.layout.simple_list_item_1 , users);

        listView.setAdapter(arrayAdapter);

        //when we click the "add" button, a pop up will appear

        Button button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomPopup customPopup = new CustomPopup(activity);
                customPopup.setTitle("Supprimer la fiche ?");
                customPopup.setSubtitle("Une fois supprimer, vous ne pouvez plus revenir en arrière.");
                customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //actions when we click on the Yes Button
                        Toast.makeText(getApplicationContext(), "OUI", Toast.LENGTH_SHORT).show();
                        customPopup.dismiss();
                    }
                });
                customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //actions when we click on the No Button
                        customPopup.dismiss();
                    }
                });

                customPopup.build();
            }
        });

    }


}