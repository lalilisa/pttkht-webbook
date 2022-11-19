package com.n10.webbook.dto.publisher;

import com.n10.webbook.common.dto.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class QueryPublisherDto extends QueryDto {
    @Schema(allowableValues = {"name"},defaultValue = "[\"name\"]")
    private String[] property;

}
