package com.royalfantasy.backend.infrastructure.rest.dto;

public class UpdatePlayerResponse {
    private final Long id;

    private UpdatePlayerResponse(Builder builder) {
        id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public static final class Builder {
        private Long id;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public UpdatePlayerResponse build() {
            return new UpdatePlayerResponse(this);
        }
    }
}
