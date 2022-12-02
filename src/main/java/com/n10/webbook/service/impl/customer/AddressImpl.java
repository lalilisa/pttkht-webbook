package com.n10.webbook.service.impl.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Address;
import com.n10.webbook.repository.customer.AddressRepository;
import com.n10.webbook.service.GennericService;
import com.n10.webbook.service.customer.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address findOneById(long id) {
        return null;
    }

    @Override
    public Address create(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public void deleleById(long id) {

    }
}
