package com.example.evalbackend.services.common;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICrud<T, ID> {

    Page<T> getAll(Pageable p) throws Exception;
    Optional<T> getById(ID id) throws Exception;
    T save(T t) throws Exception;
    T update(T t) throws Exception;
    void deleteById(ID id) throws Exception;
}
