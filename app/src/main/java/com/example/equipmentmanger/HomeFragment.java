package com.example.equipmentmanger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FloatingActionButton createSite;
    RecyclerView recyclerView;

    private static final String TAG = HomeFragment.class.getSimpleName();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        createSite = view.findViewById(R.id.create_site_floatingActionButton);
        recyclerView = view.findViewById(R.id.site_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        createSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),CreateSiteActivity.class);
                startActivity(intent);
            }
        });

        getAllSiteDetails();

        return view;
    }

    private void getAllSiteDetails(){

        Call<List<SiteResponse>> siteList =ApiClient.getInventoryService().getAllSiteDetails();

        siteList.enqueue(new Callback<List<SiteResponse>>() {
            @Override
            public void onResponse(Call<List<SiteResponse>> call, Response<List<SiteResponse>> response) {
                List<SiteResponse> siteResponses = response.body();

                recyclerView.setAdapter(new SiteAdapter(siteResponses,getActivity(),this::ClickedSites));
            }

            private void ClickedSites(SiteResponse siteResponse) {

                ClickedSite(siteResponse);
            }

            @Override
            public void onFailure(Call<List<SiteResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: api not working "+t);
            }
        });

    }

  //  @Override
    public void ClickedSite(SiteResponse siteResponse) {
        //  Toast.makeText(getContext(), ""+hotelResponse.toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(),EquipmentActivity.class);
      //  intent.putExtra("data",hotelResponse);
    //    intent.putExtra("checkIn",checkIn);
     //   intent.putExtra("checkOut",checkOut);
     //   intent.putExtra("noOfGuest",noOfGuest);
        intent.putExtra("siteId",siteResponse.getId());
        startActivity(intent);
    }
}