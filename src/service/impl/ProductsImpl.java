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
            products.add(product); // Добавить продукт
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
        // Вернуть name если id и id из списка совпали
        // Если продукта нет, то вернуть пустую строку

        for (Product prod: products) {
            if (id.equals(prod.getId())){
                return prod.getName();
            }
        }
        return "";
    }

    @Override
    public List<String> findByName(String name) {
        // Вернуть список id если name и name из списка совпали
        // Если ничего не найдено, то вернуть пустой список

        List<String> idProducts = new ArrayList<>();

        for (Product pr: products) {
            if (name.equals(pr.getName())){
                idProducts.add(pr.getId());
            }
        }
        return idProducts;
    }

    public List<Product> getProducts() {
        return products;
    }
}
