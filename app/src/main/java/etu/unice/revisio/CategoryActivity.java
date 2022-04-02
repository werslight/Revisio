package etu.unice.revisio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.CategoryAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_listview);
        Button addCategory = findViewById(R.id.addCategory);
        ListOfCategory listC = new ListOfCategory();
        CategoryAdapter adapter = new CategoryAdapter(this, listC);
        ListView list = findViewById(R.id.listView);

        list.setAdapter(adapter);
        adapter.addListener(this);

        addCategory.setOnClickListener(view -> {
            Intent add = new Intent(getApplicationContext(), EditCategory.class);
            startActivity(add);
        });

        list.setOnItemLongClickListener((adapterView, view, position, l) -> {
            new AlertDialog.Builder(CategoryActivity.this)
                    .setIcon(android.R.drawable.ic_delete)
                    .setTitle("Suppression d'une fiche")
                    .setMessage("Voulez vous supprimer cette catégorie ?")
                    .setPositiveButton("Supprimer", (dialogInterface, i) -> {
                        try {
                            Toast.makeText(CategoryActivity.this, "ooooooh No!!", Toast.LENGTH_SHORT).show();
                            listC.remove(adapter.getItem(position));
                            adapter.notifyDataSetChanged();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    })
                    .setNegativeButton("Garder", (dialogInterface, i) -> Toast.makeText(CategoryActivity.this, "Good Choice", Toast.LENGTH_SHORT).show())
                    .show();
            return true;
        });

    }

    @Override
    public void onClickName(Category item, int position) {
        Category category = new Category(item.getName(), item.getColor(), item.getFiles());
        Intent intent = new Intent(CategoryActivity.this, EditCategory.class);
        intent.putExtra(Application.CATEGORY, category);
        startActivity(intent);
    }
}
