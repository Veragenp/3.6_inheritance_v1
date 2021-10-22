package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "book1", 20, "author1");
    Product book2 = new Book(2, "book2", 30, "author2");
    Product book3 = new Book(3, "book3", 40, "King");
    Product smartphone1 = new Smartphone(1, "Sm1", 20000, "Philips");
    Product smartphone2 = new Smartphone(2, "Sm2", 30000, "author3");


    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }


    @Test
    public void shouldSearchNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthorBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("author2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNameSmartphone() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Sm1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchManufacturerSmartphone() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Philips");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("fire");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOne() {
        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = manager.searchBy("author");
        assertArrayEquals(expected, actual);
    }
}