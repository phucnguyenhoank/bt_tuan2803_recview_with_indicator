package com.example.bt_tuan2803_recview_with_indicator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
        iconList = new ArrayList<>();
        // Replace R.drawable.ic_baseline_person_24 with your actual drawable if needed.
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Person"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "User"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Profile"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Account"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Member"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Administrator"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Guest"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Moderator"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Developer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Manager"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Editor"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Subscriber"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "VIP"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Support"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Trainer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Teacher"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Doctor"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Nurse"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Engineer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Designer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Artist"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Photographer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Athlete"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Actor"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Musician"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Blogger"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Influencer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Student"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Scientist"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Pilot"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Driver"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Chef"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Waiter"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Lawyer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Judge"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Police Officer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Firefighter"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Soldier"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Astronaut"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Businessman"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Entrepreneur"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Investor"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Scientist"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Researcher"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Writer"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Poet"));
        iconList.add(new IconModel(R.drawable.ic_baseline_person_24, "Explorer"));


        // Set up the adapter.
        iconAdapter = new IconAdapter(this, iconList);
        rcIcon.setAdapter(iconAdapter);

        // Attach the indicator decoration.
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));


    }
}