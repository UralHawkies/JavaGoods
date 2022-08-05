package repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] goods = new Product[0];

    public void save(Product good) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[tmp.length - 1] = good;
        goods = tmp;
    }

    public Product[] getAll() {
        return goods;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(" Element with id " + id + " not found ");
        }
        Product[] tmp = new Product[goods.length - 1];
        int copyToIndex = 0;
        for (Product good : goods) {
            if (good.getId() != id) {
                tmp[copyToIndex] = good;
                copyToIndex++;
            }
        }
        goods = tmp;
    }

    public Product findById(int id) {
        for (Product good : goods) {
            if (good.getId() == id) {
                return good;
            }
        }
        return null;
    }
}
