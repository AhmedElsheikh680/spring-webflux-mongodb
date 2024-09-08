package com.spring.product.config;

import com.spring.product.entity.Product;
import com.spring.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class StartupApp implements CommandLineRunner {

    private final ProductService productService;
    @Override
    public void run(String... args) throws Exception {

        log.info("=============> In command Line Runner");
        productService.insert(new Product(null, "Prod 1", 22.22, "Category 1"));
        productService.insert(new Product(null, "Prod 2", 23.35, "Category 2"));
        productService.insert(new Product(null, "Prod 3", 78.14, "Category 3"));
        productService.insert(new Product(null, "Prod 4", 85.32, "Category 4"));
        productService.insert(new Product(null, "Prod 5", 10.32, "Category 5"));

    }
}
