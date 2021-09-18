package com.baeldung.springsoap.repos;

import com.baeldung.springsoap.gen.Product;
import com.baeldung.springsoap.gen.Stock;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository {
    Map<String, Product> productMap = new HashMap<>();

    @PostConstruct
    public void initMethod(){
        Stock stock = new Stock();
        stock.setLocationcode("Columbus");
        stock.setQuantity(1000);
        Product product = new Product();
        product.setProductnumber("A0001");
        product.setPrice(234.00);
        product.setStock(stock);
        product.setDescription("The best product from columbus");
        productMap.put(product.getProductnumber(), product);

        Stock stock1 = new Stock();
        stock1.setQuantity(2000);
        stock.setLocationcode("Chicago");

        Product product1 = new Product();
        product1.setDescription("Priority product from chicago");
        product1.setProductnumber("A0002");
        product1.setStock(stock1);
        product1.setPrice(6778.00);
        productMap.put(product1.getProductnumber(), product1);

    }

    public Product getProduct(String productNumber){
        Assert.notNull(productNumber, "Product's number can't be null");
        return productMap.get(productNumber);
    }
}
