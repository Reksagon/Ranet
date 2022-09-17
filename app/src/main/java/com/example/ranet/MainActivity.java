package com.example.ranet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ranet.Models.Employees;
import com.example.ranet.Network.Employee;
import com.example.ranet.Network.GetDataService;
import com.example.ranet.Network.LoginResponse;
import com.example.ranet.Network.RetrofitClientInstance;
import com.example.ranet.R;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.himanshurawat.hasher.Hasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String API_KEY = "T1YL5AWXIUMJGGBKKDTEY4I14SYIFZSW";
    EditText email_text, password_text;
    Button login;
    ProgressDialog progress;
    CheckBox checkBox;
//j.asdf2a8gtq98taza4qr
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_text = findViewById(R.id.email_text);
        password_text = findViewById(R.id.password_text);
        checkBox = findViewById(R.id.checkBox);
        progress = new ProgressDialog(this);
        login = findViewById(R.id.login);


        SharedPreferences sp1 =  PreferenceManager.getDefaultSharedPreferences(this);

        boolean login_check = sp1.getBoolean("login", false);
        if (login_check) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email_text.getText().toString().isEmpty()) {
                    if (!password_text.getText().toString().isEmpty()) {
                        progress.setTitle("Loading");
                        progress.setMessage("Wait while loading...");
                        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                        progress.show();

                        login(email_text.getText().toString(), password_text.getText().toString());
                    } else {
                        password_text.setError("Please enter Password");
                    }


                } else {
                    email_text.setError("Please enter Email");
                }

                //  login(email_text.getText().toString(),md5(password_text.getText().toString()));
                //  login(email,md5(COOKIE_KEY+password));
            }
        });

    }

    public void login(String email, String pass) {
        GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        //, "["+md5Pass+"]"
        Call<Employees> call = getDataService.getEmployees("full", "[" + email + "]", "JSON", API_KEY);
        call.enqueue(new Callback<Employees>() {
            @Override
            public void onResponse(Call<Employees> call, Response<Employees> response) {
                progress.dismiss();
                String password = pass;
                Employees employees = response.body();

                // String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
                String bcryptHashString = employees.getEmployees().get(0).getPasswd();
                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);

                if (result.verified) {
                    if (checkBox.isChecked()) {
                        SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        SharedPreferences.Editor Ed = sp.edit();
                        Ed.putBoolean("login", true).apply();
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Email or Password", Toast.LENGTH_LONG).show();
                }

                //    Toast.makeText(getApplicationContext(),""+response.body(),Toast.LENGTH_LONG);
            }

            @Override
            public void onFailure(Call<Employees> call, Throwable t) {
                if (t != null) {
                    progress.dismiss();
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
