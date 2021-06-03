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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReportFragment extends Fragment {

    RecyclerView recyclerView;

    private static final String TAG = ReportFragment.class.getSimpleName();

    int userId;

    public ReportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        recyclerView = view.findViewById(R.id.report_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        userId = getArguments().getInt("userId");

        getAllReportDetails();

        return view;
    }

    private void getAllReportDetails(){
        String id = String.valueOf(userId);

        Call<List<ReportResponse>> reportList =ApiClient.getInventoryService().getAllReportDetails(id);

        reportList.enqueue(new Callback<List<ReportResponse>>() {
            @Override
            public void onResponse(Call<List<ReportResponse>> call, Response<List<ReportResponse>> response) {

                List<ReportResponse> reportResponses = response.body();

                recyclerView.setAdapter(new ReportAdapter(reportResponses,getActivity(),this::ClickedReports));
            }

            private void ClickedReports(ReportResponse reportResponse) {

                ClickedReport(reportResponse);
            }

            @Override
            public void onFailure(Call<List<ReportResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: api not working "+t);
            }
        });

    }
    public void ClickedReport(ReportResponse reportResponse) {

        Intent intent = new Intent(getActivity(),ReportActivity.class);

       // intent.putExtra("siteId",siteResponse.getId());
        startActivity(intent);
    }

}