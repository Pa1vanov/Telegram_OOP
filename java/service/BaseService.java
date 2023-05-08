package jk.uz.pdp.service;

public interface BaseService<T> {
    int create(T t);

    T getById(Long id);

    T updateById(T update);

    int deleteById(Long id);
}
