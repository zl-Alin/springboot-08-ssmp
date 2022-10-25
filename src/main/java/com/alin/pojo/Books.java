package com.alin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
