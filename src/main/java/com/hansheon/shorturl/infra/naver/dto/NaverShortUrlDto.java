package com.hansheon.shorturl.infra.naver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NaverShortUrlDto {

    private String message;
    private String code;
    private Result result;

    public String getResultUrl() {
        return Objects.requireNonNull(result.getUrl());
    }
    public String getResultHash() {
        return Objects.requireNonNull(result.getHash());
    }
    public String getResultOriginalUrl() {
        return Objects.requireNonNull(result.getOrgUrl());
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {

        private String url;
        private String hash;
        private String orgUrl;
    }
}
