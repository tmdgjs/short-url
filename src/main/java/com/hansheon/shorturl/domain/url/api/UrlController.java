package com.hansheon.shorturl.domain.url.api;

import com.hansheon.shorturl.domain.url.application.UrlService;
import com.hansheon.shorturl.domain.url.dto.ShortUrlDto;
import com.hansheon.shorturl.domain.url.dto.ShortUrlRequest;
import com.hansheon.shorturl.global.common.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten-url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/naver")
    public ResponseEntity<BaseResponse<ShortUrlDto>> convertUrlByNaver(
            @Valid
            @RequestBody
            final ShortUrlRequest shortUrlRequest
    ) {

        ShortUrlDto shortUrlDto = urlService.convertUrlByNaver(shortUrlRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), shortUrlDto));
    }
}
