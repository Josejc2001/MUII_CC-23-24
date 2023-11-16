package com.royalfantasy.backend.infrastructure.rest.dto;

public class CreatePlayerResponse {
    private final String id;

    private CreatePlayerResponse(Builder builder) {
        id = builder.id;
    }

    public String getId() {
        return id;
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public CreatePlayerResponse build() {
            return new CreatePlayerResponse(this);
        }
    }
}
