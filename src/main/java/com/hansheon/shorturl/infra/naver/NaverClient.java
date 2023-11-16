package com.hansheon.shorturl.infra.naver;

import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlDto;
import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@FeignClient(name="naver-client", url = "${feign.naver.url}")
public interface NaverClient {

    @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8")
    NaverShortUrlDto convertShortUrl(
            @RequestHeader("X-Naver-Client-Id") final String xNaverClientId,
            @RequestHeader("X-Naver-Client-Secret") final String xNaverClientSecret,
            @RequestBody NaverShortUrlRequest naverShortUrlRequest);

}
