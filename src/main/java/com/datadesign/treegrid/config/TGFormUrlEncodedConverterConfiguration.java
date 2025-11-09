package com.datadesign.treegrid.config;

import com.datadesign.treegrid.util.TGReflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * [application/x-www-form-urlencoded] 타입의 요청을 별도로 처리하는 Bean을 등록
 */
@Configuration
public class TGFormUrlEncodedConverterConfiguration implements WebMvcConfigurer {
    @Bean
    public HttpMessageConverter<?> TGFormUrlEncodedConverter(TGReflections tgReflections) {
        TGFormUrlEncodedConverter<?> converter = new TGFormUrlEncodedConverter<>(tgReflections);
        MediaType mediaType = new MediaType(MediaType.APPLICATION_FORM_URLENCODED, StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(List.of(mediaType));
        return converter;
    }
}