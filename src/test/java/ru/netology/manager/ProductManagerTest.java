package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(1, "Book1", 100, "Author1");
    private Book book2 = new Book(2, "Book2", 100, "Author1");
    private Book book3 = new Book(3, "Book3", 100, "Author2");
    private Book book4 = new Book(4, "Book4", 100, "Author2");
    private Book book5 = new Book(5, "Book5", 100, "Author3");

    private Smartphone smartphone1 = new Smartphone(1, "Smartphone1", 1000, "Producer1");
    private Smartphone smartphone2 = new Smartphone(2, "Smartphone2", 1000, "Producer2");
    private Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 1000, "Producer1");
    private Smartphone smartphone4 = new Smartphone(4, "Smartphone4", 1000, "Producer2");
    private Smartphone smartphone5 = new Smartphone(5, "Smartphone5", 1000, "Producer3");

    @BeforeEach
    void setUp() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(book4);
        manager.save(book5);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);
        manager.save(smartphone4);
        manager.save(smartphone5);
    }

    @Test
    public void shouldFindBookByName() {
        String nameToSearch = "Book2";
        Product[] expected = new Product[] {book2};
        Product[] actual = manager.searcyBy(nameToSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAuthor() {
        String nameToSearch = "Author2";
        Product[] expected = new Product[] {book3, book4};
        Product[] actual = manager.searcyBy(nameToSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        String nameToSearch = "Smartphone2";
        Product[] expected = new Product[] {smartphone2};
        Product[] actual = manager.searcyBy(nameToSearch);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByProducer() {
        String nameToSearch = "Producer2";
        Product[] expected = new Product[] {smartphone2, smartphone4};
        Product[] actual = manager.searcyBy(nameToSearch);
        assertArrayEquals(expected, actual);
    }
}