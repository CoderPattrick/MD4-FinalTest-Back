package com.md4finaltest.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void deleteById(Long id);
}
