package com.n10.webbook.dto.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;
@Data
public class RegisterDto {

    @Schema(example = "maivantri309@gmail.com")
    String email;
    @Schema(example = "0867153008")
    String phonenumber;
    @Schema(example = "Mai")
    String firstName;
    @Schema(example = "Van")
    String midName;
    @Schema(example = "Tri")
    String lastName;
    @Schema(example = "trimai")
    String username;
    @Schema(example = "2001-08-30")
    String dob;
    @Schema(example = "123")
    String password;

}
