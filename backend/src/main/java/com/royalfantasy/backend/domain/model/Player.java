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
    public Player() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getClause() {
        return clause;
    }

    public void setClause(Integer clause) {
        this.clause = clause;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
