package virkato.otus.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final List<Product> products = new ArrayList<>();


    public void add(Product product) {
        products.add(product);
    }


    public void remove(Product product) {
        products.removeIf(p -> p.getId().equals(product.getId()));
    }


    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("-".repeat(10) + "\nYour products:\n");
        if (products.isEmpty()) {
            sb.append("Is empty yet.\n");
        } else {
            for (Product product : products) {
                sb.append(product);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
