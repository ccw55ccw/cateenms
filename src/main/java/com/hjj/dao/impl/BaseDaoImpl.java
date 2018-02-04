package com.hjj.dao.impl;

import com.hjj.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/12/14.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private HibernateTemplate template;

    private Class<T> clazz;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public Optional<T> getById(Long id) {
        return Optional.of(template.get(clazz, id));
    }

    public Optional<T> get(T t) {
        List<T> records = template.findByExample(t, -1, 1);
        if (!records.isEmpty()){
            return Optional.ofNullable(records.get(0));
        }
        return Optional.empty();
    }

    @Override
    public List<T> list() {
        return template.loadAll(clazz);
    }

    @Override
    public List<T> list(T t) {
        List<T> records = template.findByExample(t);
        return records;
    }

    public void save(T t) {
        template.save(t);
    }

    public void update(T t) {
        template.update(t);
    }

    public void delete(T t) {
        template.delete(t);
    }


}
