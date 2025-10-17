package com.datadesign;

import com.datadesign.treegrid.config.TGFormUrlEncodedConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class JsonFormUrlEncodedConverterConfiguration implements WebMvcConfigurer {
    @Bean
    public HttpMessageConverter<?> TGFormUrlEncodedConverter() {
        TGFormUrlEncodedConverter<?> converter = new TGFormUrlEncodedConverter<>();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_FORM_URLENCODED, StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(List.of(mediaType));
        return converter;
    }
}