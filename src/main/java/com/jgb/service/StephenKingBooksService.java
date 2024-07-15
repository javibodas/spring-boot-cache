package com.jgb.service;

import com.jgb.domain.books.stephenKing.StephenKingBooksResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Log4j2
public class StephenKingBooksService {

    private final WebClient client;

    public StephenKingBooksService(WebClient.Builder webClientBuilder,
                                   @Value("${com.jgb.books.apiUrl.stephenKing}") String apiUrl) {
        this.client = webClientBuilder
                .baseUrl(apiUrl)
                .build();
    }

    @Cacheable("stephenKingBooks")
    public StephenKingBooksResponse getBooks() {
        log.info("Fetching books...");
        return getAllBooks();
    }

    @CachePut("stephenKingBooks")
    public StephenKingBooksResponse refreshBooks() {
        log.info("Fetching books for refreshing...");
        return getAllBooks();
    }

    private StephenKingBooksResponse getAllBooks() {
        return client
                .get()
                .uri("/books")
                .retrieve()
                .bodyToMono(StephenKingBooksResponse.class)
                .doOnSuccess(response -> log.info("Stephen King Books obtained."))
                .block();
    }
}
