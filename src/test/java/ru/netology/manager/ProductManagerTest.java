package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(1, "Little Women", 100, "Louisa May Alcott")};
        Product[] actual = manager.searchBy("Louisa May Alcott");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, "The Adventures of Sherlock Holmes", 200, "A. Conan Doyle")};
        Product[] actual = manager.searchBy("The Adventures of Sherlock Holmes");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBySmartphoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, "iPhone XR", 1000, "Apple")};
        Product[] actual = manager.searchBy("iPhone XR");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBySmartphoneManufacturerOneItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(3, "A53", 500, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBySmartphoneManufacturerTwoItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, "iPhone XR", 1000, "Apple"),new Smartphone(5, "iPhone 6", 300, "Apple")};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBySmartphoneManufacturerNonItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }
}


