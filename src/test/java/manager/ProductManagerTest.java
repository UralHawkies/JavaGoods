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

    Product good1 = new Book(1, "Мать", 500, "Максим Горький");
    Product good2 = new Book(2, "Война и Мир", 1000, "Лев Толстой");
    Product good3 = new Book(3, "Идиот", 700, "Федор Достоевский");
    Product good4 = new Smartphone(4, "iPhone 8", 5000, "Apple");
    Product good5 = new Smartphone(5, "iPhone XR", 3000, "Apple");
    Product good6 = new Smartphone(6, "Redmi", 1500, "Xiaomi");


    @BeforeEach
    public void setup() {
        manager.add(good1);
        manager.add(good2);
        manager.add(good3);
        manager.add(good4);
        manager.add(good5);
        manager.add(good6);
    }

    @Test
    public void shouldSearchByGoodName() {
        Product[] expected = { good1 };
        Product[] actual = manager.searchBy("Мать");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindGoodByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Алексей Иванов");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralGoods() {
        Product[] expected = { good4, good5 };
        Product[] actual = manager.searchBy("iPhone");

        assertArrayEquals(expected, actual);
    }

}
