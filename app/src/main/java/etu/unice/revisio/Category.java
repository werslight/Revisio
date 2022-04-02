package etu.unice.revisio;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Category extends AppCompatActivity implements Parcelable {
    private String name;
    private int color;
    private ArrayList<File> files;

    public Category(String name, int color, ArrayList<File> files) {
        this.name = name;
        this.color = color;
        this.files = files;
    }

    protected Category(Parcel in) {
        name = in.readString();
        color = in.readInt();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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

        addCategory.setOnLongClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Supprimer");

            builder.setMessage("Supprimer la catégorie ...");
            builder.setPositiveButton("Oui", null);
            builder.setNegativeButton("Non", null);

            builder.show();
            return true;
        });

        back.setOnClickListener(view -> {
            Intent back1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(back1);
        });

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(color);
    }
}
