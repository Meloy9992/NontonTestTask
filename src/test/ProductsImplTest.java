package test;

import models.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import service.Products;
import service.impl.ProductsImpl;

import static org.junit.jupiter.api.Assertions.*;

class ProductsImplTest {
    private static ProductsImpl products = new ProductsImpl(); // Создаем экземпляр класса productsImpl
    @Test
    void addProduct() {
        Product product = new Product("0", "Молоко"); // Добавили данные в список
        Product product1 = new Product("1", "Шоколад"); // Добавили данные в список
        Product product2 = new Product("2", "Сок"); // Добавили данные в список

        products.addProduct(product); // Добавляем данные во временный массив
        products.addProduct(product1); // Добавляем данные во временный массив

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

        products.addProduct(product); // Добавление родукта
        products.addProduct(product1); // Добавление родукта
        products.addProduct(product2); // Добавление родукта

        Assert.assertTrue(products.deleteProduct(product1)); // Проверка что продукт был удален

        Assert.assertFalse(products.deleteProduct(product3)); // Проверка на отссутствие удаления продукта
    }

    @Test
    void getName() {
    }

    @Test
    void findByName() {
    }
}