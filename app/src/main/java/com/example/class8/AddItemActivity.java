package com.example.class8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.class8.Model.Item;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        EditText inputName = (EditText) findViewById(R.id.inputName);
        EditText inputAmount = (EditText) findViewById(R.id.inputAmount);

        btnAdd.setOnClickListener(view -> {
            Item newItem = new Item(String.valueOf(inputName.getText()), Integer.valueOf(String.valueOf(inputAmount.getText())));

            Intent newIntent = new Intent();
            newIntent.putExtra("item", newItem);

            setResult(RESULT_OK, newIntent);
            finish();
        });
    }
}