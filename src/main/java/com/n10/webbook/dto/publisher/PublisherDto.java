package com.n10.webbook.dto.publisher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PublisherDto {
    @JsonIgnore
    private Long id;

    @Schema(example = "Kim Đồng")
    private String name;
}
