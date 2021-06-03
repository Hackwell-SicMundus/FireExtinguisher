package com.example.equipmentmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManagementActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        userId = getIntent().getIntExtra("userId",0);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId())
                    {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_scanner:
                            selectedFragment = new ScannerFragment();
                            break;
                        case R.id.nav_report:
                            selectedFragment = new ReportFragment();
                            Bundle homeBundle = new Bundle();
                            homeBundle.putInt("userId",userId);
                            selectedFragment.setArguments(homeBundle);
                            break;
                        case R.id.nav_maintenance:
                            selectedFragment = new MaintenanceFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    return true;
                }
            };
}