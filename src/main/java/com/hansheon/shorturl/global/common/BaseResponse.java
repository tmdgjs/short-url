package com.hansheon.shorturl.global.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BaseResponse<T> {
    private int resultCode;
    private String resultMessage;

    @JsonProperty("data")
    @JsonAlias("resultData")
    private T resultData;

    public BaseResponse() {

    }

    public BaseResponse(final int resultCode, final String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public BaseResponse(final int resultCode, final String resultMessage, final T resultData) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultData = resultData;
    }
}
