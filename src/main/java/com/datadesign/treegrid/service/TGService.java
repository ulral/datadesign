package com.datadesign.treegrid.service;

import java.util.List;
import java.util.Optional;

public interface TGService<T> {
    T save(T entity);
    List<T> saveAll(List<T> entities); // 추가
    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    Class<T> getTargetType();
}
