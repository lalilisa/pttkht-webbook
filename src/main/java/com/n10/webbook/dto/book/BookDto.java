package com.n10.webbook.dto.book;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookDto {
    @JsonBackReference
    private Long id;

    @Schema(example = "Start")
    private String title;

    @Schema(example = "2022")
    private String publishYear;

    @Schema(example = "560")
    private Integer numberOfPages;

    @Schema(example = "Việt Nam")
    private String language;

    @Schema(nullable = true,example = "1")
    private Long  authorId;

    @Schema(nullable = true,example = "1")
    private Long publisherId;

}
