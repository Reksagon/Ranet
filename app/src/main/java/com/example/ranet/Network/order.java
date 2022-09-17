package com.example.ranet.Network;

import com.example.ranet.Models.Prestashop;
import com.example.ranet.Models.current_state;
import com.example.ranet.Models.id_address_delivery;
import com.example.ranet.Models.id_address_invoice;
import com.example.ranet.Models.id_carrier;
import com.example.ranet.Models.id_cart;
import com.example.ranet.Models.id_currency;
import com.example.ranet.Models.id_customer;
import com.example.ranet.Models.id_lang;
import com.example.ranet.Models.shipping_number;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(name="order")
public class order {
    @Element(name = "id")
    public int id;
    @Element(name = "id_address_delivery")
    public String id_address_delivery;
    @Element(name = "id_address_invoice")
    public String id_address_invoice;
    @Element(name = "id_cart")
    public String id_cart;
    @Element(name = "id_currency")
    public String id_currency;
    @Element(name = "id_lang")
    public String id_lang;
    @Element(name = "id_customer")
    public String id_customer;
    @Element(name = "id_carrier")
    public String id_carrier;

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    @Element(name = "current_state")
    public String current_state;
    @Element(name = "module")
    public String module;
    @Element(name = "invoice_number")
    public int invoice_number;
    @Element(name = "invoice_date")
    public String invoice_date;
    @Element(name = "delivery_number")
    public int delivery_number;
    @Element(name = "delivery_date")
    public String delivery_date;
    @Element(name = "valid")
    public int valid;
    @Element(name = "date_add")
    public String date_add;
    @Element(name = "date_upd")
    public String date_upd;
    @Element(name = "shipping_number",required = false)
    public String shipping_number;
    @Element(name = "id_shop_group")
    public int id_shop_group;
    @Element(name = "id_shop")
    public int id_shop;
    @Element(name = "secure_key")
    public String secure_key;
    @Element(name = "payment")
    public String payment;
    @Element(name = "recyclable")
    public int recyclable;
    @Element(name = "gift")
    public int gift;
    @Element(name = "gift_message", required = false)
    public String gift_message;
    @Element(name = "mobile_theme")
    public int mobile_theme;
    @Element(name = "total_discounts")
    public double total_discounts;
    @Element(name = "total_discounts_tax_incl")
    public double total_discounts_tax_incl;
    @Element(name = "total_discounts_tax_excl")
    public double total_discounts_tax_excl;
    @Element(name = "total_paid")
    public double total_paid;
    @Element(name = "total_paid_tax_incl")
    public double total_paid_tax_incl;
    @Element(name = "total_paid_tax_excl")
    public double total_paid_tax_excl;
    @Element(name = "total_paid_real")
    public double total_paid_real;
    @Element(name = "total_products")
    public double total_products;
    @Element(name = "total_products_wt")
    public double total_products_wt;
    @Element(name = "total_shipping")
    public double total_shipping;
    @Element(name = "total_shipping_tax_incl")
    public double total_shipping_tax_incl;
    @Element(name = "total_shipping_tax_excl")
    public double total_shipping_tax_excl;
    @Element(name = "carrier_tax_rate")
    public double carrier_tax_rate;
    @Element(name = "total_wrapping")
    public double total_wrapping;
    @Element(name = "total_wrapping_tax_incl")
    public double total_wrapping_tax_incl;
    @Element(name = "total_wrapping_tax_excl")
    public double total_wrapping_tax_excl;
    @Element(name = "round_mode")
    public int round_mode;
    @Element(name = "round_type")
    public int round_type;
    @Element(name = "conversion_rate")
    public double conversion_rate;
    @Element(name = "reference")
    public String reference;
    @Element(name = "associations")
    public associations associations;
}