package com.connecttosubh.repository;

import com.connecttosubh.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {
}
