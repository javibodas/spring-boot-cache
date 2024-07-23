package com.jgb.usecase;

import com.jgb.domain.books.stephenKing.StephenKingBook;
import com.jgb.domain.books.stephenKing.StephenKingBooksResponse;
import com.jgb.domain.exception.CustomException;
import com.jgb.service.StephenKingBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class GetStephenKingBooksUsecase {

    private final StephenKingBooksService service;

    public List<StephenKingBook> execute() {
        StephenKingBooksResponse response = service.getBooks();

        if (isNull(response)) throw new CustomException("Invalid stephen king books service response");

        return response.getData();
    }
}
