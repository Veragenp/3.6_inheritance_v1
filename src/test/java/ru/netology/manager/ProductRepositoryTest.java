package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "book1", 20, "author1");
    Product book2 = new Book(2, "book2", 30, "author2");
    Product book3 = new Book(3, "book3", 40, "King");
    Product smartphone1 = new Smartphone(1, "Sm1", 20000, "Philips");
    Product smartphone2 = new Smartphone(2, "Sm2", 30000, "author3");

    @Test
    public void shoutThrowFalseIdException() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void shoutRemoveTrueId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(1);
        Product[] expected = new Product[]{book2, book3};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);

}
}
