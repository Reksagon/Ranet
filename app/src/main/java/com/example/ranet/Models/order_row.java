package com.example.ranet.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "order_row")
public class order_row {
    @Element(name = "id",required = false)
    public int id;
    @Element(name = "product_id",required = false)
    public product_id product_id;
    @Element(name = "product_attribute_id",required = false)
    public int product_attribute_id;
    @Element(name = "product_quantity",required = false)
    public int product_quantity;
    @Element(name = "product_name",required = false)
    public String product_name;
    @Element(name = "product_reference",required = false)
    public String product_reference;
    @Element(name = "product_ean13",required = false)
    public double product_ean13;
    @Element(name = "product_isbn",required = false)
    public String product_isbn;
    @Element(name = "product_upc",required = false)
    public String product_upc;
    @Element(name = "product_price",required = false)
    public double product_price;
    @Element(name = "id_customization",required = false)
    public id_customization id_customization;
    @Element(name = "unit_price_tax_incl",required = false)
    public double unit_price_tax_incl;
    @Element(name = "unit_price_tax_excl",required = false)
    public double unit_price_tax_excl;
}