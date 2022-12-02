package com.n10.webbook.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IdItemDto {
    @Schema(example = "1")
    Long id;
}
