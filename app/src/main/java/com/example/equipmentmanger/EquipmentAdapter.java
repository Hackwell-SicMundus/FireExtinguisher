package com.example.equipmentmanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.EquipmentAdapterVH> {

   // private List<EquipmentResponse> equipmentResponseLists;
    private List<EquipmentResponse> equipmentResponseLists;
    private Context context;
   // private EquipmentAdapter.ClickedItem clickedItem;

    public EquipmentAdapter(List<EquipmentResponse> equipmentResponseList, Context context) {
        this.equipmentResponseLists = equipmentResponseList;
        this.context = context;

    }

    @NonNull
    @Override
    public EquipmentAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.equipment_item,parent,false);
        return new EquipmentAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipmentAdapterVH holder, int position) {
        EquipmentResponse equipmentResponse = equipmentResponseLists.get(position);

        String Location = equipmentResponse.getLandmark()+"Floor No: "+equipmentResponse.getFloor();

        holder.equipmentName.setText(String.valueOf(equipmentResponse.getName()));
        holder.equipmentLocation.setText(Location);

    /*    holder.siteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedSite(siteResponse);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return equipmentResponseLists.size();
    }

    public class EquipmentAdapterVH extends RecyclerView.ViewHolder {

        TextView equipmentName;
        TextView equipmentLocation;

        public EquipmentAdapterVH(@NonNull View itemView) {
            super(itemView);

            equipmentName=itemView.findViewById(R.id.equipment_item_name);
            equipmentLocation=itemView.findViewById(R.id.equipment_item_location);
        }
    }
}
