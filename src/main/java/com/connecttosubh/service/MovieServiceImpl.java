package com.connecttosubh.service;

import com.connecttosubh.domain.Movie;
import com.connecttosubh.event.MovieEvent;
import com.connecttosubh.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

     @Override
    public Mono<Movie> getMovieById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Movie> getMoviesAll() {
        return repository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvent(String id) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(id,new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }


}
