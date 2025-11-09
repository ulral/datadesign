package com.datadesign.treegrid.config;

import com.datadesign.treegrid.model.TGUploadForm;
import com.datadesign.treegrid.util.TGReflections;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * @TGForm 어노테이션이 작성되어있는 경우, Object를 T로 리플렉션하여 반환하여줌
 * [application/x-www-form-urlencoded]로 요청이 들어오고 그 첫번째 값이 DATA인 것만 변환을 시도
 * 따라서 TreeGrid의 Upload_Data 속성값은 반드시 "DATA" 이어야함.
 * @param <T>
 */
@SuppressWarnings("all")
public class TGFormUrlEncodedConverter<T> extends AbstractGenericHttpMessageConverter<T> {

    private final TGReflections tgReflections;

    public TGFormUrlEncodedConverter(TGReflections tgReflections) {
        this.tgReflections = tgReflections;
    }

    private static final ObjectMapper objectMapper =
            new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final FormHttpMessageConverter converter = new FormHttpMessageConverter();


    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAnnotationPresent(TGForm.class);
    }
    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {

        MultiValueMap<String, String> raw = converter.read(null, inputMessage);
        String rawJson = raw.getFirst("DATA")
                .replaceAll(",\\s*]", "]")
                .replaceAll(",\\s*}", "}")
                .trim();

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
        String rawJson = formData.getFirst("DATA")
                .replaceAll(",\\s*]", "]")
                .replaceAll(",\\s*}", "}")
                .trim();

        if (rawJson == null || rawJson.isBlank()) {
            throw new HttpMessageNotReadableException("Missing 'DATA' field", inputMessage);
        }

        try {
            Class<?> model = tgReflections.getClass(formData.getFirst("Class"));
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(TGUploadForm.class, model);
            return objectMapper.readValue(rawJson, javaType);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}