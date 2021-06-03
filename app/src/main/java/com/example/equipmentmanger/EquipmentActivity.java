package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EquipmentActivity extends AppCompatActivity {

    FloatingActionButton addEquipmentButton;
    RecyclerView recyclerView;
    String id;

    private static final String TAG = EquipmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        int siteId = getIntent().getIntExtra("siteId",0);
        id=String.valueOf(siteId);
        addEquipmentButton=findViewById(R.id.equipment_floatingActionButton);

        recyclerView = findViewById(R.id.equipment_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addEquipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquipmentActivity.this,CreateEquipmentActivity.class);
                intent.putExtra("siteId",siteId);
                startActivity(intent);
            }
        });

        getAllEquipmentDetails();

        Toast.makeText(this, "siteId"+siteId, Toast.LENGTH_SHORT).show();

    }

    private void getAllEquipmentDetails() {

        Call<List<EquipmentResponse>> equipmentList =ApiClient.getInventoryService().getAllEquipmentDetails(id);

        equipmentList.enqueue(new Callback<List<EquipmentResponse>>() {
            @Override
            public void onResponse(Call<List<EquipmentResponse>> call, Response<List<EquipmentResponse>> response) {
                List<EquipmentResponse> equipmentResponses = response.body();

                recyclerView.setAdapter(new EquipmentAdapter(equipmentResponses,EquipmentActivity.this));
            }

           /* private void ClickedEquipments(EquipmentResponse equipmentResponse) {

                ClickedEquipment(equipmentResponse);
            }*/

            @Override
            public void onFailure(Call<List<EquipmentResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: api not working "+t);
            }
        });
    }

   // public void ClickedSite(SiteResponse siteResponse) {
        //  Toast.makeText(getContext(), ""+hotelResponse.toString(), Toast.LENGTH_SHORT).show();
       // Intent intent = new Intent(EquipmentActivity.this,.class);
        //  intent.putExtra("data",hotelResponse);
        //    intent.putExtra("checkIn",checkIn);
        //   intent.putExtra("checkOut",checkOut);
        //   intent.putExtra("noOfGuest",noOfGuest);
      //  intent.putExtra("siteId",siteResponse.getId());
      //  startActivity(intent);
  //  }

}