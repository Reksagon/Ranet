package com.example.ranet.Network;

import com.example.ranet.Models.order_rows;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "associations")
public class associations {
    @Element(name = "order_rows")
    public com.example.ranet.Models.order_rows order_rows;
}