package com.royalfantasy.backend.domain.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Player {
    @Id
    private ObjectId id;
    private String name;
    private String position;
    private String age;
    private Double height;
    private Double weight;
    private Integer value;
    private Integer clause;
    private Integer points;
    // Team
    // Img
}
