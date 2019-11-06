package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private String id;
    private String name;
    private String category;
    private int count;
    private boolean status;
    private int price;
}
