package com.example.ranet.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("orders")
    @Expose
    private List<Order_> orders = null;

    public List<Order_> getOrders() {
        return orders;
    }

    public void setOrders(List<Order_> orders) {
        this.orders = orders;
    }

}