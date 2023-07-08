package com.practice.x2jReactive;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface dataRepo extends ReactiveCrudRepository<data,String> {

    Mono<Boolean> existsByName(String f);

    Mono<data> findByName(String f);

}
