package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.domain.Order;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private List<Order> list;
    private boolean status;
}
