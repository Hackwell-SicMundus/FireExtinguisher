package com.example.equipmentmanger;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportAdapterVH> {

    private List<ReportResponse> reportResponseLists;
    private Context context;
    private ReportAdapter.ClickedItem clickedItem;

    public ReportAdapter(List<ReportResponse> reportResponseList, Context context, ReportAdapter.ClickedItem clickedItem) {
        this.reportResponseLists = reportResponseList;
        this.context = context;
        this.clickedItem = clickedItem;
    }

    @NonNull
    @Override
    public ReportAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.report_item,parent,false);
        return new ReportAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapterVH holder, int position) {
        ReportResponse reportResponse = reportResponseLists.get(position);

        holder.reportItemName.setText(String.valueOf(reportResponse.getName()));
        holder.reportDate.setText(String.valueOf(reportResponse.getDate()));
        holder.reportItemId.setText(String.valueOf(reportResponse.getIdInventory()));

        int urgency = reportResponse.getUrgency();
        if(urgency==1)
        {
            holder.reportUrgency.setBackgroundColor(Color.parseColor("#7A221B"));
        }
        else if(urgency==2)
        {
            holder.reportUrgency.setBackgroundColor(Color.parseColor("#F44336"));
        }
        else if(urgency==3)
        {
            holder.reportUrgency.setBackgroundColor(Color.parseColor("#ffff56"));
        }
        else if(urgency==4)
        {
            holder.reportUrgency.setBackgroundColor(Color.parseColor("#76ff03"));
        }
        else if(urgency==5)
        {
            holder.reportUrgency.setBackgroundColor(Color.parseColor("#00c853"));
        }

    }

    public interface ClickedItem{
        public void ClickedReport(ReportResponse reportResponse);
    }

    @Override
    public int getItemCount() {
        return reportResponseLists.size();
    }

    public class ReportAdapterVH extends RecyclerView.ViewHolder {

        TextView reportItemName;
        TextView reportDate;
        TextView reportItemId;
        CardView reportItem;
        View reportUrgency;


        public ReportAdapterVH(@NonNull View itemView) {
            super(itemView);
            reportItemName=itemView.findViewById(R.id.report_item_tv);
            reportDate=itemView.findViewById(R.id.report_date_tv);
            reportItemId=itemView.findViewById(R.id.report_item_id_tv);
            reportItem=itemView.findViewById(R.id.report_item_cardview);
            reportUrgency=itemView.findViewById(R.id.divider);

        }
    }
}
