package com.royalfantasy.backend.infrastructure.rest.dto;

import java.util.List;

public class RetrieveAllPlayerResponse {
    List<RetrieveByIdPlayerResponse> playersRetrieveByIdResponse;

    private RetrieveAllPlayerResponse(Builder builder) {
        playersRetrieveByIdResponse = builder.playersRetrieveByIdResponse;
    }

    public List<RetrieveByIdPlayerResponse> getPlayersRetrieveByIdResponse() {
        return playersRetrieveByIdResponse;
    }

    public void setPlayersRetrieveByIdResponse(List<RetrieveByIdPlayerResponse> playersRetrieveByIdResponse) {
        this.playersRetrieveByIdResponse = playersRetrieveByIdResponse;
    }

    public static final class Builder {
        private List<RetrieveByIdPlayerResponse> playersRetrieveByIdResponse;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder playersRetrieveByIdResponse(List<RetrieveByIdPlayerResponse> val) {
            playersRetrieveByIdResponse = val;
            return this;
        }

        public RetrieveAllPlayerResponse build() {
            return new RetrieveAllPlayerResponse(this);
        }
    }
}
