package service.impl;

import models.Product;
import service.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsImpl implements Products {
    private List<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        // true - id нет
        // false - id сущестует

        if (products.contains(product)){
            return false;
        }else {
            products.add(product);
            return true;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public String getName(String id) {
        return null;
    }

    @Override
    public List<String> findByName(String name) {
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }
}
