package com.example.ranet;

import androidx.appcompat.app.AppCompatActivity;

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
    // RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    ProgressDialog progress;
    TextView customerName, Address, phone, productCost, shippingCost, totalCost, shippingtext,productCode;
    private ImageView mapImage;
    ScrollView scrollView;
    LinearLayout dyanmicView;
    DecimalFormat df;
    Button signature;
    String id;
    String add,city,state;
    String ApiKey = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Searched Order");
        customerName = findViewById(R.id.customerName);
        Address = findViewById(R.id.Address);

        signature = findViewById(R.id.signature);
        phone = findViewById(R.id.phone);
        productCost = findViewById(R.id.productCost);
        shippingCost = findViewById(R.id.shippingCost);
        totalCost = findViewById(R.id.totalCost);
        shippingtext = findViewById(R.id.shippingtext);
        mapImage = findViewById(R.id.mapImage);
        scrollView = findViewById(R.id.scrollView);
        dyanmicView = findViewById(R.id.dyanmicView);
        df = new DecimalFormat("0.00##");
        // recyclerView = findViewById(R.id.recyclerView);
        progress = new ProgressDialog(this);
        if(getIntent() !=null && getIntent().getExtras().containsKey("order_")){
            or = (Order_) getIntent().getSerializableExtra("order_");
            searchOrders(or);
        }

        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this,SignatureActivity.class);
                intent.putExtra("id",or.getId().toString());
                startActivity(intent);
            }
        });
        mapImage.setOnClickListener(new View.OnClickListener() {
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
/*        showProgress();
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Order> call = getDataService.getOrdersId("full", "[" + id + "]", "JSON", "L53ATVIHJVWE4Q8LIZDEZA68LIGPLP1I");
        //   .getEmployees("[email]", "["+email+"]", "["+md5Pass+"]","JSON",API_KEY);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {*/
                //     order.setOrders(response.body());
                order_ = o;
                shippingtext.setVisibility(View.VISIBLE);
                mapImage.setVisibility(View.VISIBLE);
                String totalPaid = "Products: " + df.format(Double.parseDouble(order_.getTotalPaidTaxIncl()));
                String totalShipping = "Shipping: " + df.format(Double.parseDouble(order_.getTotalShippingTaxIncl()));
                String total = "Total: " + df.format(Double.parseDouble(order_.getTotalPaidTaxIncl()));
                productCost.setText(totalPaid);
                shippingCost.setText(totalShipping);
                totalCost.setText(total);
                dyanmicView.removeAllViews();
                for (int i = 0; i < order_.getAssociations().getOrderRows().size(); i++) {
                    OrderRow orderRow = order_.getAssociations().getOrderRows().get(i);
                    View view = getLayoutInflater().inflate(R.layout.order_item_row, null);
                    TextView productName = (TextView) view.findViewById(R.id.productName);
                    TextView pricePerUnit = (TextView) view.findViewById(R.id.pricePerUnit);
                    TextView amount = (TextView) view.findViewById(R.id.amount);
                    TextView productCode = view.findViewById(R.id.productCode);
                    TextView totall = (TextView) view.findViewById(R.id.total);
                    ImageView image = (ImageView) view.findViewById(R.id.proImage);
                    // image.setBackgroundResource();
                    getProductForImage(orderRow.getProductId(), image);
                    productName.setText(orderRow.getProductName());
                    pricePerUnit.setText(df.format(Double.parseDouble(orderRow.getUnitPriceTaxIncl())));
                    amount.setText(orderRow.getProductQuantity());
                    productCode.setText(orderRow.getProductReference());
                    totall.setText(df.format(Double.parseDouble(orderRow.getProductPrice())));
                    dyanmicView.addView(view);
                }
                getAddress(order_.getIdAddressDelivery(), order_);
   //         }

/*            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                if (t != null) {
                    progress.dismiss();
                    Toast.makeText(getApplicationContext(), "Id not found", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    public void getProductForImage(String productId, ImageView image) {
        showProgress();
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Ord> call = getDataService.getProductDetails(productId, "JSON", ApiKey);
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
                if (t != null) {
                    Toast.makeText(getApplicationContext(), "Product not found, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getDefaultImage(String id, String productId, ImageView image) {
        Picasso.get().load("https://www.nettoland.ch/api/images/products/" + id + "/" + productId + "&ws_key=T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW").placeholder(R.drawable.googleg_disabled_color_18).into(image);
        progress.dismiss();
/*        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = getDataService.getDefaultImage(id,productId, "L53ATVIHJVWE4Q8LIZDEZA68LIGPLP1I");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody response1 = response.body();
                Bitmap bmp = BitmapFactory.decodeStream(response.body().byteStream());
                Picasso.get().load(response.raw().request().url().toString()).placeholder(R.drawable.googleg_disabled_color_18).into(mapImage);
              //  Picasso.with(getApplicationContext()).load("https://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(imageView)
             //   mapImage.setImageBitmap(bmp);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t != null) {
                    Toast.makeText(getApplicationContext(), "Image not found, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
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
                Address.setText(address);
                customerName.setText(cus);
                phone.setText(addressDetails.getAddress().getPhone() + "\n" + addressDetails.getAddress().getPhoneMobile());
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