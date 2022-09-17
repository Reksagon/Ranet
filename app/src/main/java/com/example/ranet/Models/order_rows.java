package com.example.ranet.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "order_rows")
public class order_rows {
  // @ElementList(name="order_row",required = false)
    @ElementList(inline = true,entry = "order_row")
    public List<order_row> order_row;
    @Element(name = "nodeType",required = false)
    public String nodeType;
    @Element(name = "virtualEntity",required = false)
    public boolean virtualEntity;
    @Element(name = "text",required = false)
    public String text;
}