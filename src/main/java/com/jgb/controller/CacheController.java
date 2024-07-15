package com.jgb.controller;

import com.jgb.domain.books.stephenKing.StephenKingBook;
import com.jgb.service.StephenKingBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final StephenKingBooksService stephenKingBooksService;

    @GetMapping("/books")
    public ResponseEntity<List<StephenKingBook>> getBooks() {
        final var booksResponse = stephenKingBooksService.getBooks();

        return ResponseEntity.ok(booksResponse.getData());
    }

    @GetMapping("/books/refresh")
    public ResponseEntity<Void> refreshBooks() {
        stephenKingBooksService.refreshBooks();

        return ResponseEntity.ok().build();
    }
}
