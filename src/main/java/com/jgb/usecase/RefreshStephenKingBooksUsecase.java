package com.jgb.usecase;

import com.jgb.domain.books.stephenKing.StephenKingBooksResponse;
import com.jgb.domain.exception.CustomException;
import com.jgb.service.StephenKingBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class RefreshStephenKingBooksUsecase {

    public final StephenKingBooksService service;

    public void execute() {
        StephenKingBooksResponse response = service.refreshBooks();

        if (isNull(response)) throw new CustomException("Invalid stephen king books service response");
    }
}
