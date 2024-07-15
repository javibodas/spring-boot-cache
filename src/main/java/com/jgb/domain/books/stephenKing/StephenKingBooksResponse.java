package com.jgb.domain.books.stephenKing;

import lombok.Data;

import java.util.List;

@Data
public class StephenKingBooksResponse {
    private List<StephenKingBook> data;
}
