package com.course.farm.abtract;


import com.course.farm.annotation.FarmNoRepository;

import java.util.List;
import java.util.Optional;

@FarmNoRepository
public interface Repository<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();

    T save(T entity);

    void deleteById(ID id);

    void delete(T entity);
}
