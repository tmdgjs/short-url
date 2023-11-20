package com.hansheon.shorturl.domain.url.application;

import com.hansheon.shorturl.domain.url.dto.ShortUrlDto;
import com.hansheon.shorturl.domain.url.dto.ShortUrlRequest;
import com.hansheon.shorturl.global.common.Base62;
import com.hansheon.shorturl.infra.naver.component.NaverComponent;
import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final NaverComponent naverComponent;

    /**
     * @title Base62를 이용한 단축 URL Redirect
     */
    public String getOriginalUrl(String base62Encoded) {
        return Base62.decode(base62Encoded);
    }

    /**
     * @title Base62를 이용한 단축 URL
     */
    public ShortUrlDto convertUrlByBase62(final HttpServletRequest request, final ShortUrlRequest shortUrlRequest) {

        String protocol = request.getScheme(); // HTTP/HTTPS
        String hostname = request.getServerName();
        int port = request.getServerPort();

        String url = shortUrlRequest.getUrl();
        String encode = Base62.encode(url);

        String newUrl = protocol + "://" + hostname + ":" + port + "/" + encode;

        return ShortUrlDto.of(newUrl, encode, url);
    }

    /**
     * @title 네이버 API를 이용한 단축 URL
     */
    public ShortUrlDto convertUrlByNaver(ShortUrlRequest shortUrlRequest) {

        String url = shortUrlRequest.getUrl();
        NaverShortUrlDto naverShortUrlDto = naverComponent.convertUrl(url);
        return ShortUrlDto.of(naverShortUrlDto);
    }
}
