package pl.springboot2.karoljanik.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.eshop.dao.ProductList;
import pl.springboot2.karoljanik.eshop.model.Product;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("PLUS")
public class ShopPLUS {

    private ProductList productList;

    @Autowired
    public ShopPLUS(ProductList productList) {
        this.productList = productList;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getProductsPlus() {
        List<Product> productListPlus = new ArrayList<>(productList.getProductList());
        for (Product product : productListPlus) {
            product.setProductName(product.getProductName());
            product.setProductPrice(product.getProductPrice().add(product.getProductPrice().multiply(product.getVat())).setScale(2, RoundingMode.HALF_UP));
            System.out.println(product);
        }
//        productList.showProducts();

    }

}
