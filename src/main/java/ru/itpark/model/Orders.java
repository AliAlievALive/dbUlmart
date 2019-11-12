package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class Orders {
    private long id;
    private List<Order> orders;
    private boolean status;
}
