package ru.itpark.repository;

import lombok.RequiredArgsConstructor;
import ru.itpark.model.Order;
import ru.itpark.model.Orders;
import ru.itpark.model.Product;
import ru.itpark.util.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrdersRepositoryJdbcImpl implements CrudRepository<Orders, Integer> {
  private final String url;
  private final JdbcTemplate jdbcTemplate;
  private int orderNumber = 1;

  @Override
  public Orders create(Orders orders) {
    String sql = "CREATE TABLE " + orderNumber++ + " INSERT INTO orders (count, name, product_cost, status) VALUES (?, ?, ?, ?);";
    for (Order order : orders.getOrders()) {

    }
    int id = jdbcTemplate.executeUpdate(url, sql, stmt -> {
      stmt.setInt(1, orders.getCount());
      stmt.setString(2, orders.getName());
      stmt.setInt(3, orders.getPrice());
      stmt.setString(2, orders.getCategory());
      stmt.setString(4, orders.getCount() > 0 ? "Make buy" : "not available");
      return stmt;
    });
    orders.setId(id);
    return orders;
  }

  @Override
  public Order updateById(Product product) {
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
