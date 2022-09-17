package com.example.ranet.Network;

import com.example.ranet.Models.AddressDetails;
import com.example.ranet.Models.Employees;
import com.example.ranet.Models.Ord;
import com.example.ranet.Models.Order;
import com.example.ranet.Models.Prestashop;
import com.example.ranet.Models.Product;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface GetDataService {
//https://www.smpc.ch/api/employees?filter[email]=MegaAdmin@smpc.ch&display=[passwd]&output_format=JSON
    @GET("employees")
    Call<Employees> getEmployees(@Query("display")String display,
                                 @Query("filter[email]")String email,
                                 //   @Query("filter[passwd])")String pass,
                                 @Query("output_format")String json,
                                 @Query("ws_key")String key);
    @GET("orders")
    Call<Order> getOrdersId(@Query("display")String display,
                            @Query("filter[id]")String email,
                            @Query("output_format")String json,
                            @Query("ws_key")String key);
    @GET("addresses/{id}")
    Call<AddressDetails> getAddressDetails(@Path("id") String id,
                                            @Query("output_format")String json,
                                            @Query("ws_key")String key);

    @GET("products/{id}")
    Call<Ord> getProductDetails(@Path("id") String id,
                                @Query("output_format")String json,
                                @Query("ws_key")String key);

    @GET("images/products/{id}/{id}")
    @Streaming
    Call<ResponseBody> getDefaultImage(@Path("id") String id,
                                       @Path("id") String idd,
                                       @Query("ws_key")String key);

    @GET("orders/{id}")
    @Headers({"Accept: application/xml"})
    Call<Prestashop> getOrderIdXML(@Path("id")String id,
                                   @Query("ws_key")String key);
    @PUT("orders")
    @Headers({"Accept: application/xml"})
    Call<Prestashop> putOrderState(@Body Prestashop prestashop,
                                   @Query("ws_key")String key);
    @Multipart
    @POST("ordersign/{id}")
    Call<ResponseBody> putImageInDatabase(@Path("id")String id,
                                         @Query("output_format")String json,
                                         @Part MultipartBody.Part file,
                                         @Query("ws_key")String key);
}
