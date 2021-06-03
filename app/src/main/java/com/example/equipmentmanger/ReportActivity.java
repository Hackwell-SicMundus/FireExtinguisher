package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReportActivity extends AppCompatActivity {

    TextView reportEquipmentName;
    TextView reportId;
    TextView reportLocation;
    TextView reportDate;
    TextView reportDescription;
    TextView reportUserName;
    TextView reportUrgency;
    CardView reportUrgencyCardView;
    Button reportSolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        reportEquipmentName.findViewById(R.id.report_name_textView);
        reportId.findViewById(R.id.report_id_textView);
        reportLocation.findViewById(R.id.report_location_textView);
        reportDate.findViewById(R.id.report_date_textView);
        reportDescription.findViewById(R.id.report_issue_textView);
        reportUserName.findViewById(R.id.report_userName_textView);
        reportUrgency.findViewById(R.id.report_urgence_textView);
        reportUrgencyCardView.findViewById(R.id.report_urgence_cardView);

    }
}