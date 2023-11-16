package com.hansheon.shorturl.domain.url.application;

import com.hansheon.shorturl.domain.url.dto.ShortUrlDto;
import com.hansheon.shorturl.domain.url.dto.ShortUrlRequest;
import com.hansheon.shorturl.infra.naver.component.NaverComponent;
import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final NaverComponent naverComponent;

    public ShortUrlDto convertUrlByNaver(ShortUrlRequest shortUrlRequest) {

        String url = shortUrlRequest.getUrl();
        NaverShortUrlDto naverShortUrlDto = naverComponent.convertUrl(url);
        return ShortUrlDto.of(naverShortUrlDto);
    }
}
