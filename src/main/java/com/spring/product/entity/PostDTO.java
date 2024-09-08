package com.spring.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {

    private static final long serialVersionUID= -973790642300432737L;

    private Long id;
    private String title;
    private String body;
    private Long userId;

}
