package com.example.equipmentmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateSiteActivity extends AppCompatActivity {

    EditText siteName;
    EditText siteLocation;
    Button siteAddButton;

    CreateSiteRequest createSiteRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_site);

        siteName=findViewById(R.id.siteName_editText);
        siteLocation=findViewById(R.id.siteLoc_editText);
        siteAddButton=findViewById(R.id.site_add_button);

        createSiteRequest = new CreateSiteRequest();

        siteAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                createSiteRequest.setName(siteName.getText().toString());
                createSiteRequest.setLocation(siteLocation.getText().toString());

                Call<String> createSiteRequestCall = ApiClient.getInventoryService().saveCreateSite(createSiteRequest);

                createSiteRequestCall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(CreateSiteActivity.this, "Successful:response"+createSiteRequest.getName()+createSiteRequest.getLocation(), Toast.LENGTH_SHORT).show();
                        String responses = response.body();
                     /*   if(response.isSuccessful())
                        {
                            Toast.makeText(CreateSiteActivity.this,"Saved Successfully", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(CreateSiteActivity.this,"Failed to save", Toast.LENGTH_SHORT).show();
                        }*/


                   //     Fragment homeFragment = new HomeFragment();
                        //    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,homeFragment).commit();

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(CreateSiteActivity.this, "Failed pls try again", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}