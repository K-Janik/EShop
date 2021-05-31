package pl.springboot2.karoljanik.eshop.dao;

import org.springframework.stereotype.Repository;
import pl.springboot2.karoljanik.eshop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static List<Product> productList =new ArrayList<>();

    public ProductRepository() {
        Product product1 = new Product("Gacie");
        Product product2 = new Product("Lacie");
        Product product3 = new Product("Fuzekle");
        Product product4 = new Product("Czapka");
        Product product5 = new Product("Bluza");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void showProducts() {
        productList.forEach(System.out::println);
    }

}
