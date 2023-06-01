package test;

import models.Product;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import service.Products;
import service.impl.ProductsImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsImplTest {
    private  ProductsImpl products = new ProductsImpl(); // Создаем экземпляр класса productsImpl
    @Test
    void addProduct() {
        Product product = new Product("0", "Молоко"); // Добавили данные в список
        Product product1 = new Product("1", "Шоколад"); // Добавили данные в список
        Product product2 = new Product("2", "Сок"); // Добавили данные в список

        products.addProduct(product); // Добавление продукта
        products.addProduct(product1); // Добавление продукта

        // Сравнение последнего элемента из списка и элементом который мы добавили
        Assert.assertEquals(products.getProducts().get(products.getProducts().size() - 1), product1);

        //Проверка что элемент существует
        Assert.assertFalse(products.addProduct(product1));

        //Проверка что элемент не существует
        Assert.assertTrue(products.addProduct(product2));
    }

    @Test
    void deleteProduct() {
        Product product = new Product("0", "Молоко"); // Добавили данные в список
        Product product1 = new Product("1", "Шоколад"); // Добавили данные в список
        Product product2 = new Product("2", "Сок"); // Добавили данные в список
        Product product3 = new Product("3", "Мороженное"); // Добавили данные в список

        products.addProduct(product); // Добавление продукта
        products.addProduct(product1); // Добавление продукта
        products.addProduct(product2); // Добавление продукта

        Assert.assertTrue(products.deleteProduct(product1)); // Проверка что продукт был удален

        Assert.assertFalse(products.deleteProduct(product3)); // Проверка на отссутствие удаления продукта
    }

    @Test
    void getName() {
        Product product = new Product("0", "Молоко"); // Добавили данные в список
        Product product1 = new Product("1", "Шоколад"); // Добавили данные в список
        Product product2 = new Product("2", "Сок"); // Добавили данные в список
        Product product3 = new Product("3", "Мороженное"); // Добавили данные в список

        products.addProduct(product); // Добавление продукта
        products.addProduct(product1); // Добавление продукта
        products.addProduct(product2); // Добавление продукта
        products.addProduct(product3); // Добавление продукта

        Assert.assertEquals(products.getName("1"), "Шоколад");
    }

    @Test
    void findByName() {
        Product product = new Product("0", "Молоко"); // Добавили данные в список
        Product product1 = new Product("1", "Шоколад"); // Добавили данные в список
        Product product2 = new Product("2", "Сок"); // Добавили данные в список
        Product product3 = new Product("3", "Мороженное"); // Добавили данные в список

        products.addProduct(product); // Добавление продукта
        products.addProduct(product1); // Добавление продукта
        products.addProduct(product2); // Добавление продукта
        products.addProduct(product3); // Добавление продукта

        List<String> idProducts = new ArrayList<>();
        idProducts.add("2");
        Assert.assertEquals(products.findByName("Конфета").size(), 0);
        Assert.assertEquals(products.findByName("Сок"), idProducts);
    }
}