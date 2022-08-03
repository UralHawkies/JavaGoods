package manager;

import repository.ProductRepository;
import ru.netology.domain.Product;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager (ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product good) {
        repo.save(good);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product good : repo.getAll()) {
            if (matches(good, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = good;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product good, String search) {
        if (good.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

