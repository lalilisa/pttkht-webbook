package com.n10.webbook.service.impl.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.dto.publisher.PublisherDto;
import com.n10.webbook.entity.Publisher;
import com.n10.webbook.repository.book.PublisherRepository;
import com.n10.webbook.service.PublisherService;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherImpl extends AbstractJpaDAO<Publisher> implements PublisherService {
    @Autowired
    private com.n10.webbook.repository.book.PublisherRepository PublisherRepository;


    public PublisherImpl() {
        super(Publisher.class);
    }

    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
    }

    @Override
    public List<Publisher> findAll() {
        return PublisherRepository.findAll();
    }

    @Override
    public Publisher create(Publisher entity) {
        return PublisherRepository.save(entity);
    }

    @Override
    public Publisher update(Publisher entity) {

        return PublisherRepository.save(entity);
    }

    @Override
    public Publisher findOneById(long id) {
        return this.findOne(id);
    }

    @Override
    public void deleleById(long id) {
        PublisherRepository.deleteById(id);
    }
}
