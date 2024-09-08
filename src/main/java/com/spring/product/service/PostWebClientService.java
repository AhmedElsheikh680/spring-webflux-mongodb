package com.spring.product.service;


import com.spring.product.entity.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.sound.midi.VoiceStatus;

@Service
public class PostWebClientService {

    private static String BASE_URL = "https://jsonplaceholder.typicode.com";

    WebClient webClient = WebClient.create(BASE_URL);

    public Flux<PostDTO> findByName(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/posts")
                        .queryParam("name", name)
                        .build())
//                .headers(headers -> headers.setBasicAuth("user", "userpwd"))
                .retrieve()
                .bodyToFlux(PostDTO.class);
    }

    public Mono<PostDTO> findById(Long id) {
        return webClient.get()
                .uri("/posts/" + id)
//                .headers(headers -> headers.setBasicAuth("user", "userpwd"))
                .retrieve()
                .bodyToMono(PostDTO.class);
    }

    public Flux<PostDTO> findALl() {
        return webClient.get()
                .uri("/posts")
//                .headers(httpHeaders -> httpHeaders.setBasicAuth("user", "userpwd"))
                .retrieve()
                .bodyToFlux(PostDTO.class);

    }

    public Mono<PostDTO> insert(PostDTO postDTO) {
        return webClient.post()
                .uri("/posts")
//                .headers(headers -> headers.setBasicAuth("admin", "adminpwd"))
                .body(Mono.just(postDTO), PostDTO.class)
                .retrieve()
                .bodyToMono(PostDTO.class);
    }

    public Mono<PostDTO> update(PostDTO postDTO) {
        return webClient.put()
                .uri("/posts/"+ postDTO.getId())
//                .headers(headers -> headers.setBasicAuth("user", "adminpwd"))
                .body(Mono.just(postDTO), PostDTO.class)
                .retrieve()
                .bodyToMono(PostDTO.class);
    }

    public Mono<Void> deletebyId(Long id) {
        return webClient.delete()
                .uri("/posts/" +id)
//                .headers(headers -> headers.setBasicAuth("admin", "adminpwd"))
                .retrieve()
                .bodyToMono(Void.class);
    }


}
