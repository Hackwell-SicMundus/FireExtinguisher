package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class UserReportActivity extends AppCompatActivity {

    TextView reportEquipmentName;
    TextView reportEquipmentId;
    TextView reportLocation;
    EditText reportDescription;
    RatingBar reportUrgency;
    Button reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report);

        reportEquipmentName=findViewById(R.id.user_report_equipment_name);
        reportEquipmentId=findViewById(R.id.user_report_equipment_id);
        reportLocation=findViewById(R.id.user_report_location);
        reportDescription=findViewById(R.id.user_report_issue_editText);
        reportUrgency=findViewById(R.id.user_report_ratingBar);
        reportButton=findViewById(R.id.user_report_button);
    }
}