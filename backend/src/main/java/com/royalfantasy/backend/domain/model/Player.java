package com.royalfantasy.backend.domain.model;

public class Player {
    private Long id;
    private String name;
    private String position;
    private Integer age;
    private Double height;
    private Double weight;
    private Integer value;
    private Integer clause;
    private Integer points;
    private String team;
    public Player() {
    }

    public Player(Long id, String name, String position, Integer age, Double height, Double weight, Integer value, Integer clause, Integer points, String team) {
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

    private Player(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setPosition(builder.position);
        setAge(builder.age);
        setHeight(builder.height);
        setWeight(builder.weight);
        setValue(builder.value);
        setClause(builder.clause);
        setPoints(builder.points);
        setTeam(builder.team);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String position;
        private Integer age;
        private Double height;
        private Double weight;
        private Integer value;
        private Integer clause;
        private Integer points;
        private String team;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder position(String val) {
            position = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder height(Double val) {
            height = val;
            return this;
        }

        public Builder weight(Double val) {
            weight = val;
            return this;
        }

        public Builder value(Integer val) {
            value = val;
            return this;
        }

        public Builder clause(Integer val) {
            clause = val;
            return this;
        }

        public Builder points(Integer val) {
            points = val;
            return this;
        }

        public Builder team(String val) {
            team = val;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
