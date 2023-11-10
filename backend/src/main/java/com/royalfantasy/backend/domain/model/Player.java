package com.royalfantasy.backend.domain.model;

public class Player {
    private Long id;
    private String name;
    private String position;
    private String age;
    private Double height;
    private Double weight;
    private Integer value;
    private Integer clause;
    private Integer points;
    private String team;
    public Player() {
    }

    public Player(Long id, String name, String position, String age, Double height, Double weight, Integer value, Integer clause, Integer points, String team) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.value = value;
        this.clause = clause;
        this.points = points;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
