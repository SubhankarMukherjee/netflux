package com.connecttosubh.controller;

import com.connecttosubh.domain.Movie;
import com.connecttosubh.event.MovieEvent;
import com.connecttosubh.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @GetMapping("/{id}")
    Mono<Movie> getMovieById(@PathVariable String id){
        return service.getMovieById(id);
    }
    @GetMapping
    Flux<Movie> getAllMovies(){
        return service.getMoviesAll();
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id){
        return service.streamMovieEvent(id);
    }
}
