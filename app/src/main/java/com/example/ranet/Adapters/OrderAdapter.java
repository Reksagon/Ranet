package com.example.ranet.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ranet.Models.Order;
import com.example.ranet.Models.Order_;
import com.example.ranet.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    Order order;
    int pos = 0;
    public OrderAdapter(Order order){
            this.order = order;
    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.order_item_row, parent, false);
        ViewHolder viewHolderr = new ViewHolder(listItem);
        return viewHolderr;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        pos = position;
        Order_ order_ = order.getOrders().get(position);
        if(order_.getAssociations().getOrderRows().size()>1){
            for(int i = 0 ; i<order_.getAssociations().getOrderRows().size(); i++){
                holder.orderImage.setBackgroundResource(R.drawable.ic_launcher_background);
                holder.orderId.setText(""+order_.getId());
                holder.orderName.setText(""+order_.getAssociations().getOrderRows().get(i).getProductName());
                holder.quantity.setText(""+order_.getAssociations().getOrderRows().get(i).getProductQuantity());
            }
        }else{
            holder.orderImage.setBackgroundResource(R.drawable.ic_launcher_background);
            holder.orderId.setText(""+order_.getId());
            holder.orderName.setText(""+order_.getAssociations().getOrderRows().get(0).getProductName());
            holder.quantity.setText(""+order_.getAssociations().getOrderRows().get(0).getProductQuantity());
        }

    }
    public void filterList(Order filterdNames) {
        this.order = filterdNames;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return order.getOrders().size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView orderImage;
        public TextView orderId;
        public TextView orderName;
        public TextView quantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
/*            this.orderImage = (ImageView)itemView.findViewById(R.id.orderImage);
            this.orderId = (TextView)itemView.findViewById(R.id.orderId);
            this.orderName = (TextView)itemView.findViewById(R.id.orderName);
            this.quantity = (TextView)itemView.findViewById(R.id.quantity);*/
        }
    }
}
