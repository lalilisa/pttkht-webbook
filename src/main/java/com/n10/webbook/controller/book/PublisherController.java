package com.n10.webbook.controller.book;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/publisher")
@SecurityRequirement(name = "webbook")
public class PublisherController {
}
