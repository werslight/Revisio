package etu.unice.revisio;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FileActivity extends AppCompatActivity implements FileAdapter.FileAdapterListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_listview);

        Button addCategory = findViewById(R.id.addCategory);
        ListOfFile listF = new ListOfFile();
        listF.createList(this);
        FileAdapter adapter = new FileAdapter(this, listF);

        ListView list = findViewById(R.id.listView);
        list.setAdapter(adapter);
        adapter.addListener(this);

        addCategory.setOnClickListener(view -> {
                Intent add = new Intent(getApplicationContext(), EditFile.class);
            startActivity(add);
        });

        list.setOnItemLongClickListener((adapterView, view, position, l) -> {
            new AlertDialog.Builder(FileActivity.this)
                    .setIcon(android.R.drawable.ic_delete)
                    .setTitle("Suppression d'une fiche")
                    .setMessage("Voulez vous supprimer cette fiche ?")
                    .setPositiveButton("Supprimer", (dialogInterface, i) -> {
                        try {
                            Toast.makeText(FileActivity.this, "Supression good", Toast.LENGTH_SHORT).show();
                            view.setVisibility(View.GONE);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    })
                    .setNegativeButton("Garder", (dialogInterface, i) -> Toast.makeText(FileActivity.this, "Good Choice", Toast.LENGTH_SHORT).show())
                    .show();
            return true;
        });
    }

    @Override
    public void onClickName(File item, int position) {
        File files = new File(item.getName(),item.getColor(), item.getQuestions());
        Intent intent = new Intent(FileActivity.this, QuestionsActivity.class);
        intent.putExtra(Application.FILES, files);
        startActivity(intent);
    }
}
