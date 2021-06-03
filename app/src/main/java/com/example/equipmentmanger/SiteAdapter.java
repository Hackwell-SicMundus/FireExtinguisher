package com.example.equipmentmanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.SiteAdapterVH> {

    private List<SiteResponse> siteResponseLists;
    private Context context;
    private SiteAdapter.ClickedItem clickedItem;


    public SiteAdapter(List<SiteResponse> siteResponseList, Context context,ClickedItem clickedItem) {
        this.siteResponseLists = siteResponseList;
        this.context = context;
        this.clickedItem = clickedItem;
    }

    @NonNull
    @Override
    public SiteAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.site_item,parent,false);
        return new SiteAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteAdapterVH holder, int position) {
        SiteResponse siteResponse = siteResponseLists.get(position);

        holder.siteName.setText(String.valueOf(siteResponse.getName()));
        holder.siteLocation.setText(String.valueOf(siteResponse.getLocation()));

        holder.siteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedSite(siteResponse);
            }
        });

    }

    public interface ClickedItem{
        public void ClickedSite(SiteResponse siteResponse);
    }

    @Override
    public int getItemCount() {
        return siteResponseLists.size();
    }

    public class SiteAdapterVH extends RecyclerView.ViewHolder {

        TextView siteName;
        TextView siteLocation;
        CardView siteItem;

        public SiteAdapterVH(@NonNull View itemView) {
            super(itemView);

            siteName=itemView.findViewById(R.id.site_item_name_tv);
            siteLocation=itemView.findViewById(R.id.site_item_location_tv);
            siteItem=itemView.findViewById(R.id.site_item_cardview);


        }
    }
}
