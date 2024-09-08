package com.spring.product.service;

import com.spring.product.entity.Product;
import com.spring.product.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Mono<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> insert(Product product) {
        return productRepository.insert(product);
    }

    public Mono<Product> update(Product product) {
        return productRepository.save(product);
    }

    public Mono<Void> deleteById(Long id) {
        return productRepository.deleteById(id);
    }

}
