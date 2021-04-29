package pl.springboot2.karoljanik.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.eshop.dao.ProductRepository;
import pl.springboot2.karoljanik.eshop.model.Product;

import java.math.RoundingMode;
import java.util.List;

@Service
@Profile("PRO")
public class ShopPRO {

    private ProductRepository productRepository;

    @Autowired
    public ShopPRO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getProductsPro() {
        List<Product> productListPro = productRepository.getProductList();
        for (Product product : productListPro) {
            product.setProductPrice(product.getProductPrice().add(product.getProductPrice().multiply(product.getVat())).multiply(product.getDiscount()).setScale(2, RoundingMode.HALF_UP));
            System.out.println(product);
        }

//        productList.showProducts();

    }
}
