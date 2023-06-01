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

        if (products.contains(product)){ // Если продукт содержится
            return false;
        }else {
            products.add(product); // Добавить продукт в отдельный элемент
            return true;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        // true - если id был
        // false - если id не было

        if (products.contains(product)){ // Если продукт содержится в списке
            products.remove(product); // Удалить продукт
            return true;
        } else return false;
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
