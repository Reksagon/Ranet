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
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity{
    Button search;
    TextView employeeName, email;
    EditText editTextTextPersonName;
    ProgressDialog progress;
    Order order;
    Order_ order_;
    ConstraintLayout mainLayout;
    String ApiKey = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";
    private AppBarConfiguration mAppBarConfiguration;
    RelativeLayout relativeLayout;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTextPersonName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Something in search field.", Toast.LENGTH_LONG);
                } else {
                    searchOrders(editTextTextPersonName.getText().toString());
                    editTextTextPersonName.setText("");
                }
            }
        });
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTextPersonName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Something in search field.", Toast.LENGTH_LONG);
                } else {
                    searchOrders(editTextTextPersonName.getText().toString());
                    editTextTextPersonName.setText("");
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