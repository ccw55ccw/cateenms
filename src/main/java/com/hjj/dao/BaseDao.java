package com.hjj.dao;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/12/14.
 */
public interface BaseDao<T> {
    Optional<T> getById(Long id);

    Optional<T> get(T t);

    List<T> list();

    List<T> list(T t);

    void save(T t);

    void update(T t);

    void delete(T t);

}
