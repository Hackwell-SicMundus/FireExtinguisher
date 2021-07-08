package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
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

    int itemId;
    String itemName;
    int Urgency;
    String date;
    int itemReportId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        reportEquipmentName=findViewById(R.id.report_name_textView);
        reportId=findViewById(R.id.report_id_textView);
        reportLocation=findViewById(R.id.report_location_textView);
        reportDate=findViewById(R.id.report_date_textView);
        reportDescription=findViewById(R.id.report_issue_textView);
        reportUserName=findViewById(R.id.report_userName_textView);
        reportUrgency=findViewById(R.id.report_urgence_textView);
        reportUrgencyCardView=findViewById(R.id.report_urgence_cardView);

        Intent intent= getIntent();
        itemName=intent.getStringExtra("itemName");
        date=intent.getStringExtra("date");
        Urgency=intent.getIntExtra("urgency",0);
        itemId=intent.getIntExtra("itemId",0);

        reportEquipmentName.setText(itemName);
        reportDate.setText(date);
        reportId.setText(String.valueOf(itemId));

        if(Urgency==1)
        {
            reportUrgencyCardView.setBackgroundColor(Color.parseColor("#7A221B"));
        }
        else if(Urgency==2)
        {
            reportUrgencyCardView.setBackgroundColor(Color.parseColor("#F44336"));
        }
        else if(Urgency==3)
        {
            reportUrgencyCardView.setBackgroundColor(Color.parseColor("#ffff56"));
        }
        else if(Urgency==4)
        {
            reportUrgencyCardView.setBackgroundColor(Color.parseColor("#76ff03"));
        }
        else if(Urgency==5)
        {
            reportUrgencyCardView.setBackgroundColor(Color.parseColor("#00c853"));
        }

    }
}