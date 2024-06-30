package virkato.otus.repository;

import java.util.List;
import java.util.Optional;


public interface Repository<T> {
    void addAll(List<T> items);

    T add(T entity);

    List<T> getAll();

    Optional<T> get(Integer id);

    void delete(Integer id);
}
