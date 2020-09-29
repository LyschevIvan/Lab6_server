package com.company.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;



public class Data implements Serializable {
    private String[] message;
    private Collection products;

    public Data(String[] message) {
        this.message = message;
    }
    public Data(String message) {
        this.message = new String[1];
        this.message[0] = message;
    }

    public Data(Collection products) {
        this.products = products;
    }

    public Data(String[] message, Collection products) {
        this.message = message;
        this.products = products;
    }

    public String[] getMessage() {
        return message;
    }

    public Collection getProducts() {
        return products;
    }
}
