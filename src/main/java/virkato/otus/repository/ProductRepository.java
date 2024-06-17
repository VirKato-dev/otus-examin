package virkato.otus.repository;

import org.springframework.stereotype.Component;
import virkato.otus.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements Repository<Product> {

    private final List<Product> products = new ArrayList<>();


    @Override
    public void addAll(List<Product> items) {
        items.forEach(i -> {
            i.setId(products.size() + 1);
            products.add(i);
        });
    }


    @Override
    public Product add(Product entity) {
        products.add(entity);
        entity.setId(products.size());
        return entity;
    }


    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }


    @Override
    public Optional<Product> get(Integer id) {
        return products.stream().filter(e -> e.getId().equals(id)).findFirst();
    }


    @Override
    public void delete(Integer id) {
        products.removeIf(e -> e.getId().equals(id));
    }
}
