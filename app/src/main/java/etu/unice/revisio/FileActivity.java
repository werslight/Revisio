package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FileActivity extends AppCompatActivity implements CategoryAdapter.CategoryAdapterListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

    }

    @Override
    public void onClickName(Category item, int position) {

    }
}
