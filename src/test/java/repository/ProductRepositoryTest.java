package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Мать",500, "Максим Горький");
    Product book2 = new Book(2, "Война и Мир", 1000, "Лев Толстой");
    Product book3 = new Book(3, "Идиот", 700, "Федор Достоевский");
    Product smartphone1 = new Smartphone(4, "iPhone8", 5000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy Note", 3000, "Samsung");
    Product smartphone3 = new Smartphone(6, "Redmi", 1500, "Xiaomi");

    @Test
    public void shouldSaveAndRemoveBooks() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(book1.getId());

        Product[] expected = {book2, book3};
        Product[] actual = repo.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfIncorrectId() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(25);
        });
    }
}
