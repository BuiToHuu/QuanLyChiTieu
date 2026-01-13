package com.example.quanlychitieu.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private Long userId;
    private String name;
    private String color;
    private String icon;
}
