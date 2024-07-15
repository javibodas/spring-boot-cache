package com.jgb.service;

import com.jgb.domain.books.stephenKing.StephenKingBooksResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Log4j2
public class StephenKingBooksService {

    private final RestClient client;

    public StephenKingBooksService(@Value("${com.jgb.books.baseUrl.stephenKing}") String baseUrl) {

        this.client = RestClient.builder()
                .baseUrl(baseUrl)
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
                .onStatus(HttpStatusCode::is2xxSuccessful, ((request, response) -> log.info("Books obtained successfully")))
                .body(StephenKingBooksResponse.class);
    }
}
