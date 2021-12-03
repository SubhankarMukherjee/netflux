package com.connecttosubh.service;

import com.connecttosubh.domain.Movie;
import com.connecttosubh.event.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getMoviesAll();

    Flux<MovieEvent> streamMovieEvent(String id);
}
