package org.example.sq_ch8_2.services;

import org.example.sq_ch8_2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.example.sq_ch8_2.model.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProduct() {
        return products;
    }
}