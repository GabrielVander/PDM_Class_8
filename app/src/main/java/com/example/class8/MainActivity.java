package com.example.class8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.class8.Adapter.MyItemRecyclerViewAdapter;
import com.example.class8.Model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyItemRecyclerViewAdapter mAdapter = new MyItemRecyclerViewAdapter(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        Button btnAddItem = (Button) findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);

            startActivityForResult(intent, 1);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK) {
            assert data != null;
            mAdapter.addItem((Item) data.getSerializableExtra("item"));
        }
    }
}