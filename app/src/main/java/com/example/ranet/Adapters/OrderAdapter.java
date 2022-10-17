package com.example.ranet.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ranet.Models.Ord;
import com.example.ranet.Models.Order;
import com.example.ranet.Models.OrderRow;
import com.example.ranet.Models.Order_;
import com.example.ranet.Network.GetDataService;
import com.example.ranet.Network.RetrofitClientInstance;
import com.example.ranet.R;
import com.example.ranet.databinding.LayoutOrderItemBinding;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAdapterVH> {

    List<OrderRow> orderRows;
    DecimalFormat df;
    public OrderAdapter(List<OrderRow> orderRows) {
        this.orderRows = orderRows;
        df = new DecimalFormat("0.00##");
    }

    @NonNull
    @Override
    public OrderAdapter.OrderAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutOrderItemBinding itemBinding = LayoutOrderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new OrderAdapter.OrderAdapterVH(itemBinding);
    }

    @Override
    public void onBindViewHolder(OrderAdapter.OrderAdapterVH holder, int position) {
        holder.bind(orderRows.get(position));
    }

    @Override
    public int getItemCount() {
        return orderRows.size();
    }

    public class OrderAdapterVH extends RecyclerView.ViewHolder {

        LayoutOrderItemBinding binding;

        public OrderAdapterVH(@NonNull LayoutOrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(OrderRow order) {
            image(order.getProductId(), binding.roundedImageView);
            binding.txtProductName.setText(order.getProductName());
            binding.txtPrice.setText(df.format(Double.parseDouble(order.getUnitPriceTaxIncl())));
            binding.txtAmount.setText(order.getProductQuantity());
            binding.txtProductCode.setText(order.getProductReference());
            binding.txtTotal.setText(df.format(Double.parseDouble(order.getProductPrice())));

        }

        private void image(String productId, ImageView image)
        {
            GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<Ord> call = getDataService.getProductDetails(productId, "JSON", "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW");
            call.enqueue(new Callback<Ord>() {
                @Override
                public void onResponse(Call<Ord> call, Response<Ord> response) {
                    Ord ord = response.body();
                    if(ord!=null){
                        getDefaultImage(productId, ord.getProduct().getIdDefaultImage(), image);
                    }
                }

                @Override
                public void onFailure(Call<Ord> call, Throwable t) {

                }
            });
        }

        public void getDefaultImage(String id, String productId, ImageView image) {
            Picasso.get().load("https://www.nettoland.ch/api/images/products/" + id + "/" + productId + "&ws_key=T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW").placeholder(R.drawable.googleg_disabled_color_18).into(image);
        }

    }
}
