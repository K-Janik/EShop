package pl.springboot2.karoljanik.eshop.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal vat;
    private BigDecimal discount;

    public Product(String productName) {
        this.productName = productName;
        this.productPrice = BigDecimal.valueOf(50 + (double)(Math.random() * ((300 - 50) + 1))).setScale(2, RoundingMode.HALF_UP);
        this.vat = BigDecimal.valueOf(0.23);
        this.discount = BigDecimal.valueOf(0.8);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
