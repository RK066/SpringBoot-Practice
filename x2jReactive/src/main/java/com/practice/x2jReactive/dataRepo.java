package com.practice.x2jReactive;


import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface dataRepo extends R2dbcRepository<data,String> {

    Mono<Boolean> existsByName(String f);

    Mono<data> findByName(String f);

}
