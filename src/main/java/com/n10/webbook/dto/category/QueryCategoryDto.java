package com.n10.webbook.dto.category;

import com.n10.webbook.common.dto.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class QueryCategoryDto extends QueryDto {
    @Schema(allowableValues = {"type"},defaultValue = "[\"type\"]")
    private String[] property;
}
