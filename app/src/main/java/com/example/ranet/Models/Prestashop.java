package com.example.ranet.Models;

import com.example.ranet.Network.order;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;
@Root(name = "Prestashop")
public class Prestashop {
    @Element(name = "order")
    public com.example.ranet.Network.order order;










}
