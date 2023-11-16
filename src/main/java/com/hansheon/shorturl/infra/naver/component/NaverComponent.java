package com.hansheon.shorturl.infra.naver.component;

import com.hansheon.shorturl.infra.naver.NaverClient;
import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlDto;
import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NaverComponent {

    // Value
    @Value("${naver.client-id}")
    private String NAVER_CLIENT_ID;

    @Value("${naver.client-secret}")
    private String NAVER_CLIENT_SECRET;

    // Feign
    private final NaverClient naverClient;

    public NaverShortUrlDto convertUrl(final String url) {
        return naverClient.convertShortUrl(NAVER_CLIENT_ID, NAVER_CLIENT_SECRET, NaverShortUrlRequest.of(url));
    }
}
