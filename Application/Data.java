package com.company.Application;

import com.company.Application.ProductClasses.Product;

import java.io.Serializable;
import java.util.Arrays;

public class Data implements Serializable {
    private String[] message;
    private Product product;
    private int productId;

    public Data(String[] message) {
        this.message = message;
    }
    public Data(String message) {
        this.message = new String[1];
        this.message[0] = message;
    }

    public Data(String[] message, Product product) {
        this.message = message;
        this.product = product;
    }

    public Data(int productId, Product product) {
        this.product = product;
        this.productId = productId;
    }

    public Data(String[] message, int productId,Product product) {
        this.message = message;
        this.product = product;
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public String[] getMessage() {
        return message;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (message != null)
            Arrays.stream(message).forEach(s -> stringBuilder.append(s).append('\n'));


        if (product!= null){
            stringBuilder.append(productId).append(" ").append(product.toString());
        }

        return stringBuilder.toString();
    }
}