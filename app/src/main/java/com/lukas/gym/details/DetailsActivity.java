package com.lukas.gym.details;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukas.gym.R;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private final DetailsAdapter detailsAdapter = new DetailsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setUi();

        String passedData = getIntent().getExtras().getString("KEY");

        ArrayList data = new ArrayList();
        data.add(passedData);

        detailsAdapter.setData(data);
    }

    private void setUi() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(detailsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}