package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Мать", 500, "Максим Горький");
    Product book2 = new Book(2, "Война и Мир", 1000, "Лев Толстой");
    Product book3 = new Book(3, "Идиот", 700, "Федор Достоевский");
    Product smartphone1 = new Smartphone(4, "iPhone8", 5000, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy Note", 3000, "Samsung");
    Product smartphone3 = new Smartphone(6, "Redmi", 1500, "Xiaomi");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Мать");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Лев Толстой");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("iPhone8");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMadeBy() {
        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("Xiaomi");

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFindBookByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Алексей Иванов");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSmartphoneByMadeBy() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Fly");

        assertArrayEquals(expected, actual);
    }

}
