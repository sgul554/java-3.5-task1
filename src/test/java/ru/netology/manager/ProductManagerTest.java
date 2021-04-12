package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void shouldSearchBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 700, "Булгаков");
        Book book2 = new Book(2, "Азазель", 300, "Акунин");
        Book book3 = new Book(3, "Хроники Амбера", 1000, "Желязны");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Азазель");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 700, "Булгаков");
        Book book2 = new Book(2, "Азазель", 300, "Акунин");
        Book book3 = new Book(3, "Хроники Амбера", 1000, "Желязны");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Желязны");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTwoBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 700, "Булгаков");
        Book book2 = new Book(2, "Азазель", 300, "Акунин");
        Book book3 = new Book(3, "Мастер и Маргарита", 200, "Булгаков");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Мастер и Маргарита");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Xiaomi", 35000, "Korea");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 15000, "Korea");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTwoSmartphoneProducer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Xiaomi", 35000, "Korea");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 15000, "Korea");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Korea");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Мастер и Маргарита", 700, "Булгаков");
        Book book2 = new Book(2, "Xiaomi", 300, "Акунин");
        Book book3 = new Book(3, "Мастер и Маргарита", 200, "Булгаков");
        Smartphone smartphone1 = new Smartphone(1, "Xiaomi", 35000, "Korea");
        Smartphone smartphone2 = new Smartphone(2, "Honor", 15000, "Korea");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{book2, smartphone1};
        assertArrayEquals(expected, actual);
    }


}