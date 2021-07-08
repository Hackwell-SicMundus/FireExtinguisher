package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateEquipmentActivity extends AppCompatActivity {

    EditText equipmentName;
    EditText equipmentFloor;
    EditText equipmentLandmark;
    Button equipmentAddButton;
    int id;

    CreateEquipmentRequest createEquipmentRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_equipment);

        id = getIntent().getIntExtra("siteId",0);


        equipmentName=findViewById(R.id.EquipmentName_editText);
        equipmentFloor=findViewById(R.id.EquipmentFloor_editText);
        equipmentLandmark=findViewById(R.id.EquipmentLandMark_editText);
        equipmentAddButton=findViewById(R.id.equipment_add_button);

        createEquipmentRequest = new CreateEquipmentRequest();

        equipmentAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEquipmentRequest.setId(id);
                createEquipmentRequest.setName(equipmentName.getText().toString());
                createEquipmentRequest.setFloor(equipmentFloor.getText().toString());
                createEquipmentRequest.setLandmark(equipmentLandmark.getText().toString());


                Call<String> createEquipmentRequestCall = ApiClient.getInventoryService().saveCreateEquipment(createEquipmentRequest);

                createEquipmentRequestCall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(CreateEquipmentActivity.this, "Successful:response"+createEquipmentRequest.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateEquipmentActivity.this,EquipmentActivity.class);
                        startActivity(intent);
                        //String responses = response.body();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(CreateEquipmentActivity.this, "Failed pls try again", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}