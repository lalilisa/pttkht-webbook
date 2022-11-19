package com.n10.webbook.controller.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.util.ConvertDtoToEntity;
import com.n10.webbook.common.util.response.ResponseHander;

import com.n10.webbook.dto.publisher.PublisherDto;
import com.n10.webbook.dto.publisher.QueryPublisherDto;
import com.n10.webbook.entity.Publisher;
import com.n10.webbook.service.PublisherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/publisher")
@SecurityRequirement(name = "webbook")
@Tag(name="Publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @GetMapping("")
    public ResponseEntity<?> listPublishers(@ParameterObject QueryPublisherDto queryDto) throws JsonProcessingException {
        return  ResponseHander.response(publisherService.findAll(queryDto), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getOnePublisher(@PathVariable Long id)  {

        return  ResponseHander.response(publisherService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<?> createPublishers(@RequestBody PublisherDto publisherDto) {
        Publisher publisher= ConvertDtoToEntity.map(publisherDto,Publisher.class);
        return  ResponseHander.response(publisherService.create(publisher), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> upadatePublishers(@PathVariable Long id,@RequestBody PublisherDto publisherDto) {
        Publisher publisher=publisherService.findOneById(id);
        publisher.setName(publisherDto.getName());
        return  ResponseHander.response(publisherService.update(publisher), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePublishers(@PathVariable Long id) {
        publisherService.deleleById(id);
        return  ResponseHander.response("Success", HttpStatus.OK);
    }
}
