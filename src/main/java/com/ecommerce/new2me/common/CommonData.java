package com.ecommerce.new2me.common;

import com.ecommerce.new2me.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CommonData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
    public static List<Product> wishlist;
    static {
        wishlist = new ArrayList<Product>();
    }
}
