package com.connecttosubh.bootstrap;

import com.connecttosubh.domain.Movie;
import com.connecttosubh.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class loadMovie implements CommandLineRunner {
    private final MovieRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                                "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                              //  .map(movie-> new Movie(movie))
                                .map(Movie::new)
                                .flatMap(repository::save)
                        ).subscribe(null,null,() -> {
                         repository.findAll().subscribe(System.out::println);
                });



    }
}
