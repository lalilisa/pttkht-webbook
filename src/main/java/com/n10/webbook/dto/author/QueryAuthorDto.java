package com.n10.webbook.dto.author;

import com.n10.webbook.common.dto.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class QueryAuthorDto extends QueryDto {
    @Schema(allowableValues = {"name","nickName"},defaultValue = "[\"name\",\"nickName\"]")
    private String[] property;
}
