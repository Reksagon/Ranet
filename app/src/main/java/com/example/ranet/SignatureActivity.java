package com.example.ranet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ranet.Models.Order;
import com.example.ranet.Models.Prestashop;
import com.example.ranet.Network.GetDataService;
import com.example.ranet.Network.RetrofitClientInstance;
import com.example.ranet.Utils.CapturePhotoUtils;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignatureActivity extends AppCompatActivity {
    SignaturePad mSignaturePad;
    Button orderStateChange;
    ProgressDialog progress;
    private static final int PERMISSION_REQUEST_CODE = 1;
    String id;
    Bitmap url;
    String ApiKey = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign Order");
        progress = new ProgressDialog(this);
        if (getIntent() != null && getIntent().getExtras().containsKey("id")) {
            id = getIntent().getStringExtra("id");
        }
        orderStateChange = findViewById(R.id.orderStateChange);
        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

            @Override
            public void onStartSigning() {
                //Event triggered when the pad is touched
            }

            @Override
            public void onSigned() {
                //Event triggered when the pad is signed

            }

            @Override
            public void onClear() {
                //Event triggered when the pad is cleared
            }
        });
        orderStateChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermission()) {
                        // Code for above or equal 23 API Oriented Device
                        // Your Permission granted already .Do next code
                        Bitmap bitmap = CapturePhotoUtils.insertImage(getContentResolver(), mSignaturePad.getSignatureBitmap(), "signature", "orderSignature");
                        if (bitmap != null) {
                            setImage(persistImage(bitmap, "orderImage", getApplicationContext()));
                            //    searchOrders(id);
                            //finish();
                        }else{
                            Toast.makeText(getApplicationContext(), "Image is not saved", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        requestPermission(); // Code for permission
                    }
                } else {// Code for Below 23 API Oriented Device
                    // Do next code
                    if (checkPermission()) {
                        // Code for above or equal 23 API Oriented Device
                        // Your Permission granted already .Do next code
                        Bitmap bitmap = CapturePhotoUtils.insertImage(getContentResolver(), mSignaturePad.getSignatureBitmap(), "signature", "orderSignature");
                        if (bitmap != null) {
                            setImage(persistImage(bitmap, "orderImage", getApplicationContext()));
                            //    searchOrders(id);
                            //finish();
                        }else{
                            Toast.makeText(getApplicationContext(), "Image is not saved", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        requestPermission(); // Code for permission
                    }
                }

            }
        });
    }

    private static File persistImage(Bitmap bitmap, String name, Context context) {
        File filesDir = context.getFilesDir();
        File imageFile = new File(filesDir, name + ".jpg");

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e("tag", "Error writing bitmap", e);
        }
        return imageFile;
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(SignatureActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(SignatureActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(SignatureActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(SignatureActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                    url = CapturePhotoUtils.insertImage(getContentResolver(), mSignaturePad.getSignatureBitmap(), "signature", "orderSignature");
                    if (url != null) {
                        Toast.makeText(SignatureActivity.this, "Image Added Successfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }

    public void showProgress() {
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    public void searchOrders(String id) {
        showProgress();
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstanceTwo().create(GetDataService.class);
        Call<Prestashop> call = getDataService.getOrderIdXML(id, ApiKey);
        call.enqueue(new Callback<Prestashop>() {
            @Override
            public void onResponse(Call<Prestashop> call, Response<Prestashop> response) {
                progress.dismiss();
                Prestashop prestashop = response.body();
                Toast.makeText(SignatureActivity.this, "Order State is updating", Toast.LENGTH_LONG).show();
                putCurrentState(prestashop);
            }

            @Override
            public void onFailure(Call<Prestashop> call, Throwable t) {
                if (t != null) {
                    if(progress !=null){
                        progress.dismiss();
                    }
                    Log.v("tttttt",""+t.getStackTrace());
                    Toast.makeText(getApplicationContext(), "Id not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setImage(File url) {
        if (url != null) {
            showProgress();

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), url);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", url.getName(), requestFile);
            GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<ResponseBody> call = getDataService.putImageInDatabase(id, "JSON", body, ApiKey);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    progress.dismiss();
                    Toast.makeText(SignatureActivity.this, "Image Added Successfully", Toast.LENGTH_LONG).show();
                    searchOrders(id);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    if (t != null) {
                        progress.dismiss();
                        Toast.makeText(getApplicationContext(), "Image not saved", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //finish();
        }
    }

    public void putCurrentState(Prestashop prestashop) {
        showProgress();
        prestashop.order.setCurrent_state("33");
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstanceTwo().create(GetDataService.class);
        Call<Prestashop> call = getDataService.putOrderState(prestashop, ApiKey);
        call.enqueue(new Callback<Prestashop>() {
            @Override
            public void onResponse(Call<Prestashop> call, Response<Prestashop> response) {
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "Order State Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignatureActivity.this, SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Prestashop> call, Throwable t) {
                if (t != null) {
                    progress.dismiss();
                    Toast.makeText(getApplicationContext(), "Order State not updated", Toast.LENGTH_SHORT).show();
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