package org.example.entity;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long UserId;
    private String name;
    private String address;
}
