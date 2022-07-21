package com.example.evalbackend.services.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract JpaRepository<T,ID> getRepository();

    @Override
    public Page<T> getAll(Pageable p) throws Exception {
        return getRepository().findAll(p);
    }

    @Override
    public Optional<T> getById(ID id) throws Exception {
        return getRepository().findById(id);
    }

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public void deleteById(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
