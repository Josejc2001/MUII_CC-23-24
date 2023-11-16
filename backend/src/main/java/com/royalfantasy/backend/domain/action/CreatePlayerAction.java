package com.royalfantasy.backend.domain.action;

public class CreatePlayerAction {
    private final String name;
    private final String position;
    private final Integer age;
    private final Double height;
    private final Double weight;
    private final Integer value;
    private final Integer clause;
    private final Integer points;
    private final String team;

    public CreatePlayerAction() {
        name=null;
        position=null;
        age=null;
        height=null;
        weight=null;
        value=null;
        clause=null;
        points=null;
        team=null;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Integer getAge() {
        return age;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getClause() {
        return clause;
    }

    public Integer getPoints() {
        return points;
    }

    public String getTeam() {
        return team;
    }

    private CreatePlayerAction(Builder builder) {
        name = builder.name;
        position = builder.position;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
        value = builder.value;
        clause = builder.clause;
        points = builder.points;
        team = builder.team;
    }


    public static final class Builder {
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

        public CreatePlayerAction build() {
            return new CreatePlayerAction(this);
        }
    }
}
