package ru.itpark.repository;

import lombok.RequiredArgsConstructor;
import ru.itpark.model.Product;
import ru.itpark.util.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductRepositoryJdbcImpl implements CrudRepository<Product, Integer> {
  private final String url;
  private final JdbcTemplate jdbcTemplate;

  @Override
  public Product create(Product product) {
    String sql = "INSERT INTO products (name, category, count, price) VALUES (?, ?, ?, ?);";
    int id = jdbcTemplate.executeUpdate(url, sql, stmt -> {
      stmt.setString(1, product.getName());
      stmt.setString(2, product.getCategory());
      stmt.setInt(3, product.getCount());
      stmt.setString(4, product.getCount() > 0 ? "Make buy" : "not available");
      stmt.setInt(5, product.getPrice());
      return stmt;
    });
    product.setId(id);
    return product;
  }

  @Override
  public Product updateById(Product product) {
    String sql = "UPDATE products SET name = ?, category = ?, count = ?, price = ? WHERE id = ?;";
    jdbcTemplate.executeUpdate(url, sql, stmt -> {
      stmt.setString(1, product.getName());
      stmt.setString(2, product.getCategory());
      stmt.setInt(3, product.getCount());
      stmt.setString(4, product.getCount() > 0 ? "Make buy" : "not available");
      stmt.setInt(5, product.getPrice());
      return stmt;
    });
    return product;
  }

  @Override
  public boolean removeById(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Product> getAll() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Optional<Product> getById(Integer id) {
    throw new UnsupportedOperationException();
  }
}
