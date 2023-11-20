package com.hansheon.shorturl.domain.url.api;

import com.hansheon.shorturl.domain.url.application.UrlService;
import com.hansheon.shorturl.domain.url.dto.ShortUrlDto;
import com.hansheon.shorturl.domain.url.dto.ShortUrlRequest;
import com.hansheon.shorturl.global.common.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{base62Encoded}")
    public ResponseEntity<?> redirect(
            @PathVariable
            final String base62Encoded
    ) {

        HttpHeaders headers = new HttpHeaders();
        String originalUrl = urlService.getOriginalUrl(base62Encoded);
        headers.setLocation(URI.create(originalUrl));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<BaseResponse<ShortUrlDto>> convertUrlByBase62(
            final HttpServletRequest request,
            @Valid
            @RequestBody
            final ShortUrlRequest shortUrlRequest
    ) {
        ShortUrlDto shortUrlDto = urlService.convertUrlByBase62(request, shortUrlRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), shortUrlDto));
    }

    @PostMapping("/shorten-url/naver")
    public ResponseEntity<BaseResponse<ShortUrlDto>> convertUrlByNaver(
            @Valid
            @RequestBody
            final ShortUrlRequest shortUrlRequest
    ) {

        ShortUrlDto shortUrlDto = urlService.convertUrlByNaver(shortUrlRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), shortUrlDto));
    }
}
