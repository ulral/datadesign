package com.datadesign;

import com.datadesign.treegrid.TGUploadForm;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@SuppressWarnings("all")
public class TGFormUrlEncodedConverter<T> extends AbstractGenericHttpMessageConverter<T> {

    private static final ObjectMapper objectMapper =
            new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final FormHttpMessageConverter converter = new FormHttpMessageConverter();

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAnnotationPresent(TGFormData.class);
    }
    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {

        MultiValueMap<String, String> raw = converter.read(null, inputMessage);
        String rawJson = raw.getFirst("DATA");

        if (rawJson == null || rawJson.isBlank()) {
            throw new HttpMessageNotReadableException("Missing 'DATA' field", inputMessage);
        }
        return objectMapper.readValue(rawJson, clazz);
    }


    @Override
    protected void writeInternal(T clazz, HttpOutputMessage outputMessage)
            throws HttpMessageNotWritableException {}

    @Override
    protected void writeInternal(T t, @Nullable Type type, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {}

    @Override
    public T read(Type type, @Nullable Class<?> contextClass, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        MultiValueMap<String, String> formData = converter.read(null, inputMessage);
        String rawJson = formData.getFirst("DATA");

        if (rawJson == null || rawJson.isBlank()) {
            throw new HttpMessageNotReadableException("Missing 'DATA' field", inputMessage);
        }
        JavaType javaType = objectMapper.getTypeFactory().constructType(type);
        return objectMapper.readValue(rawJson, javaType);
    }
}