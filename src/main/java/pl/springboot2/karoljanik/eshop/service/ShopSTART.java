package pl.springboot2.karoljanik.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.eshop.dao.ProductRepository;

@Service
@Profile("START")
public class ShopSTART {

    private ProductRepository productRepository;

    @Autowired
    public ShopSTART(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getProducts() {
        productRepository.showProducts();
    }
}
