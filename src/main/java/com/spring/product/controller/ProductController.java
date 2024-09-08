package com.spring.product.controller;


import com.spring.product.entity.PostDTO;
import com.spring.product.entity.Product;
import com.spring.product.repo.ProductRepository;
import com.spring.product.service.PostWebClientService;
import com.spring.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @Autowired
    private final PostWebClientService postWebClientService;


    @GetMapping(value = "/name/{name}", produces = "text/event-stream")
    public Flux<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }
    @GetMapping(value = "/{id}", produces = "text/event-stream")
    public Mono<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(value = "", produces = "text/event-stream")
    public Flux<Product> findAll() {
        return productService.findAll();
    }
    @PostMapping(value = "", produces = "text/event-stream")
    public Mono<Product> insert(@RequestBody Product product) {
        return productService.insert(product);
    }
    @PutMapping(value = "", produces = "text/event-stream")
    public Mono<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }
    @DeleteMapping(value = "/{id}", produces = "text/event-stream2")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return productService.deleteById(id);
    }


    @GetMapping(value = "/posts", produces = "text/event-stream")
    public Flux<PostDTO> findAllPosts() {
        return postWebClientService.findALl();
    }



    // Mono return 0 or 1 element
//    @GetMapping(value = "", produces = {"text/event-stream"})
//    public Mono<ResponseEntity<Integer>> getProductCountReactive() {
//        return Mono.just(ResponseEntity.ok(20));
//    }
//
//    @GetMapping("/all")
//    public List<Integer> products() throws InterruptedException {
//        List<Integer> products = new ArrayList<>();
//        for (int i=0; i<20; i++){
//            products.add(i+1);
//            Thread.sleep(500);
//        }
//        return products;
//    }
//
//@GetMapping(value = "/all-reactive", produces = {"text/event-stream"})
//    public Flux<Integer> productsReactive() {
//        return Flux.create(fluxList -> {
//            for (int i=0; i<20; i++){
//                fluxList.next(i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            fluxList.complete();
//        });
//    }
}
