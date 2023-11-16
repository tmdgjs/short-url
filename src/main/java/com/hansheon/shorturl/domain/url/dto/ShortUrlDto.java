package com.hansheon.shorturl.domain.url.dto;

import com.hansheon.shorturl.infra.naver.dto.NaverShortUrlDto;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShortUrlDto {

    private String url;
    private String hash;
    private String originalUrl;

    public static ShortUrlDto of (final NaverShortUrlDto naverShortUrlDto) {
        return new ShortUrlDto(
                naverShortUrlDto.getResultUrl(),
                naverShortUrlDto.getResultHash(),
                naverShortUrlDto.getResultOriginalUrl());
    }
}
