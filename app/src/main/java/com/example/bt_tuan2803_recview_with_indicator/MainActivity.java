package com.example.bt_tuan2803_recview_with_indicator;

import static java.util.Locale.filter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcIcon;
    private IconAdapter iconAdapter;
    private List<IconModel> iconList;

    private List<IconModel> originalIconList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the RecyclerView and set a horizontal LinearLayoutManager.
        rcIcon = findViewById(R.id.rcIcon);
        rcIcon.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Initialize sample data.
        originalIconList = new ArrayList<>();
        // Replace R.drawable.ic_baseline_person_24 with your actual drawable if needed.
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Person"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "User"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Profile"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Account"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Member"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Administrator"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Guest"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Moderator"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Developer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Manager"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Editor"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Subscriber"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "VIP"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Support"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Trainer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Teacher"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Doctor"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Nurse"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Engineer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Designer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Artist"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Photographer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Athlete"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Actor"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Musician"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Blogger"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Influencer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Student"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Scientist"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Pilot"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Driver"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Chef"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Waiter"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Lawyer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Judge"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Police Officer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Firefighter"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Soldier"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Astronaut"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Businessman"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Entrepreneur"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Investor"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Scientist"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Researcher"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Writer"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Poet"));
        originalIconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Explorer"));


        // Set up the adapter.
        iconList = new ArrayList<>(originalIconList);
        iconAdapter = new IconAdapter(this, iconList);
        rcIcon.setAdapter(iconAdapter);

        // Attach the indicator decoration.
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));

        // Setup SearchView
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

    }

    // Filter method to update the RecyclerView based on search text
    private void filter(String text) {
        List<IconModel> filteredList = new ArrayList<>();
        for (IconModel icon : originalIconList) {
            if (icon.getDesc().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(icon);
            }
        }
        iconAdapter.updateData(filteredList);
    }
}