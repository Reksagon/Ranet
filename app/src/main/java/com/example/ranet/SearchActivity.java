package com.example.ranet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ranet.Models.Order;
import com.example.ranet.Models.OrderRow;
import com.example.ranet.Models.Order_;
import com.example.ranet.Network.GetDataService;
import com.example.ranet.Network.RetrofitClientInstance;
import com.example.ranet.databinding.ActivitySearchBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity{

    ProgressDialog progress;
    Order order;
    Order_ order_;
    String ApiKey = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";
    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progress = new ProgressDialog(this);
        binding.bttnBackSearch.setOnClickListener(v->{
            super.onBackPressed();
        });

        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edttxtSearch.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Something in search field.", Toast.LENGTH_LONG);
                } else {
                    searchOrders(binding.edttxtSearch.getText().toString());
                    binding.edttxtSearch.setText("");
                }
            }
        });
    }

    public void showProgress() {
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    public void searchOrders(String id) {
        showProgress();
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Order> call = getDataService.getOrdersId("full", "[" + id + "]", "JSON", ApiKey);
        //   .getEmployees("[email]", "["+email+"]", "["+md5Pass+"]","JSON",API_KEY);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                //     order.setOrders(response.body());
                progress.dismiss();
                order = response.body();
                order_ = response.body().getOrders().get(0);
                Intent intent = new Intent(SearchActivity.this, OrderActivity.class);
                intent.putExtra("order_", (Serializable) order_);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                if (t != null) {
                    progress.dismiss();
                    Toast.makeText(getApplicationContext(), "Id not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}