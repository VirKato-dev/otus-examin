package virkato.otus.service;

import org.springframework.stereotype.Component;
import virkato.otus.exception.ProductNotFound;
import virkato.otus.model.Product;
import virkato.otus.repository.ProductRepository;

import java.util.List;


@Component
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProducts(List<Product> products) {
        productRepository.addAll(products);
    }


    public Product create(Product product) {
        return productRepository.add(product);
    }


    public List<Product> getAll() {
        return productRepository.getAll();
    }


    public Product get(int id) {
        return productRepository.get(id).orElseThrow(ProductNotFound::new);
    }


    public void delete(int id) {
        productRepository.delete(id);
    }
}
