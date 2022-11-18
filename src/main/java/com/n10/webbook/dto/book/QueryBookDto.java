package com.n10.webbook.dto.book;

import com.n10.webbook.common.dto.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class QueryBookDto extends QueryDto {
    @Schema(allowableValues = {"title","language"},defaultValue = "[\"title\",\"language\"]")
    private String[] property;
}
