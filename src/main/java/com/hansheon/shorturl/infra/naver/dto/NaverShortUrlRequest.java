package com.hansheon.shorturl.infra.naver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NaverShortUrlRequest {

    private String url;

    public static NaverShortUrlRequest of (final String url) {
        return new NaverShortUrlRequest(url);
    }
}
