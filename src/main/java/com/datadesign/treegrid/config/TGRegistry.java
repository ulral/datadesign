package com.datadesign.treegrid.config;

import com.datadesign.treegrid.service.TGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TGServiceMappingRegistry {
    private final Map<Class<?>, TGService<?>> registry = new HashMap<>();

    @Autowired
    public TGServiceMappingRegistry(List<TGService<?>> services) {
        for (TGService<?> service : services) {
            registry.put(service.getTargetType(), service);
        }
    }

    public TGService<?> getService(Class<?> clazz) {
        return registry.get(clazz);
    }

    @SuppressWarnings("unchecked")
    public <T> void saveAll(Class<T> clazz, List<?> data) {
        TGService<T> service = (TGService<T>) registry.get(clazz);
        if (service == null) {
            throw new IllegalArgumentException("등록되지 않은 타입입니다: " + clazz.getName());
        }
        service.saveAll((List<T>) data);
    }
}
