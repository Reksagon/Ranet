package com.example.ranet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ranet.Adapters.OrderAdapter;
import com.example.ranet.Models.AddressDetails;
import com.example.ranet.Models.Ord;
import com.example.ranet.Models.OrderRow;
import com.example.ranet.Models.Order_;
import com.example.ranet.Models.Product;
import com.example.ranet.Network.Employee;
import com.example.ranet.Network.GetDataService;
import com.example.ranet.Network.RetrofitClientInstance;
import com.example.ranet.databinding.ActivityOrder2Binding;
import com.example.ranet.databinding.ActivitySearchBinding;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    Order_ order_;
    Order_ or;
    AddressDetails addressDetails;
    OrderAdapter orderAdapter;
    ProgressDialog progress;

    DecimalFormat df;
    String id;
    String add,city,state;
    String ApiKey = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";

    ActivityOrder2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrder2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Searched Order");
        df = new DecimalFormat("0.00##");
        progress = new ProgressDialog(this);
        if(getIntent() !=null && getIntent().getExtras().containsKey("order_")){
            or = (Order_) getIntent().getSerializableExtra("order_");
            searchOrders(or);
        }

        binding.bttnSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this,SignatureActivity.class);
                intent.putExtra("id",or.getId().toString());
                startActivity(intent);
            }
        });
        binding.edttxtMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addd = "geo:0,0?q=1600" + add +","+ city+"," + state;
                Uri gmmIntentUri = Uri.parse(addd);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

    public void showProgress() {
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    public void searchOrders(Order_ o) {
        order_ = o;
        String totalPaid = df.format(Double.parseDouble(order_.getTotalPaidTaxIncl()));
        String totalShipping = df.format(Double.parseDouble(order_.getTotalShippingTaxIncl()));
        String total = df.format(Double.parseDouble(order_.getTotalPaidTaxIncl()));
        binding.txtTotalSearched.setText(total);
        binding.txtShipping.setText(totalShipping);
        binding.txtProducts.setText(totalPaid);

        orderAdapter = new OrderAdapter(order_.getAssociations().getOrderRows());
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        binding.orderItems.setLayoutManager(linearLayout);
        binding.orderItems.setAdapter(orderAdapter);

        getAddress(order_.getIdAddressDelivery(), order_);


    }


    public void getAddress(String id, Order_ order_) {
        showProgress();
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<AddressDetails> call = getDataService.getAddressDetails(id, "JSON", ApiKey);
        call.enqueue(new Callback<AddressDetails>() {
            @Override
            public void onResponse(Call<AddressDetails> call, Response<AddressDetails> response) {
                progress.dismiss();
                addressDetails = response.body();
                add = addressDetails.getAddress().getAddress1();
                city = addressDetails.getAddress().getCity();
                state = addressDetails.getAddress().getIdState();
                String address = addressDetails.getAddress().getAddress1() + " " + addressDetails.getAddress().getAddress2() + "\n" +addressDetails.getAddress().getPostcode() + " "+addressDetails.getAddress().getCity();
                String cus = addressDetails.getAddress().getFirstname() + " " + addressDetails.getAddress().getLastname();
                binding.edttxtMap.setText(cus + "," + address);
//                customerName.setText(cus);
//                phone.setText(addressDetails.getAddress().getPhone() + "\n" + addressDetails.getAddress().getPhoneMobile());
                order_.setAddress(address);
                order_.setName(cus);
                order_.setPhone(addressDetails.getAddress().getPhone());


            }

            @Override
            public void onFailure(Call<AddressDetails> call, Throwable t) {
                if (t != null) {
                    Toast.makeText(getApplicationContext(), "Address not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}