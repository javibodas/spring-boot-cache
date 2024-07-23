package com.jgb.controller;

import com.jgb.domain.books.stephenKing.StephenKingBook;
import com.jgb.usecase.GetStephenKingBooksUsecase;
import com.jgb.usecase.RefreshStephenKingBooksUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final GetStephenKingBooksUsecase getStephenKingBooksUsecase;
    private final RefreshStephenKingBooksUsecase refreshStephenKingBooksUsecase;

    @GetMapping("/books")
    public ResponseEntity<List<StephenKingBook>> getBooks() {
        final var booksResponse = getStephenKingBooksUsecase.execute();

        return ResponseEntity.ok(booksResponse);
    }

    @PostMapping("/books/refresh")
    public ResponseEntity<Void> refreshBooks() {
        refreshStephenKingBooksUsecase.execute();

        return ResponseEntity.ok().build();
    }
}
