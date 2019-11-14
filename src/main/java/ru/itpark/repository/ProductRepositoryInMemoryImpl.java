package ru.itpark.repository;

import ru.itpark.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryInMemoryImpl implements CrudRepository<Product, Integer> {
    @Override
    public Product create(Product object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product updateById(Product object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeById(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Product> getById(Integer integer) {
        throw new UnsupportedOperationException();
    }
}
