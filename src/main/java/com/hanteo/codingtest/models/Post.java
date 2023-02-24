package com.hanteo.codingtest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private Long boardId;
}
