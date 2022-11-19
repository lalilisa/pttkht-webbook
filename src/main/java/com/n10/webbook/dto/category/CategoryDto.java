package com.n10.webbook.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryDto {
    @Schema(example = "Love")
    private String type;
}
