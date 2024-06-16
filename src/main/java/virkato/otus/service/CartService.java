package virkato.otus.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import virkato.otus.model.Cart;

@Component
public class CartService {

    private final ApplicationContext context;
    private final ProductService productService;


    public CartService(ApplicationContext context, ProductService productService) {
        this.context = context;
        this.productService = productService;
    }


    public Cart createCart() {
        return context.getBean(Cart.class);
    }


    public void addProductToCart(Cart cart, int productId) {
        cart.add(productService.get(productId));
    }

    public void removeProductFromCart(Cart cart, int productId) {
        cart.remove(productService.get(productId));
    }
}
