package com.jgb.domain.books.stephenKing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StephenKingBook {

    private Long id;
    @JsonProperty("Year")
    private Integer year;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("ISBN")
    private String isbn;
    @JsonProperty("Pages")
    private Long pages;
    @JsonProperty("created_at")
    private String createdAt;

}
