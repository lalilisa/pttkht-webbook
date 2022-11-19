package com.n10.webbook.dto.author;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class AuthorDto {
    @JsonIgnore
    private Long id;

    @Schema(example = "TriMai")
    private String name;

    @Schema(example = "2001-08-30")
    private Date dateOfBirth;

    @Schema(example = "Wibu")
    private String nickName;
}
