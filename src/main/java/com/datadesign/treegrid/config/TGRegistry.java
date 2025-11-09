package com.datadesign.treegrid.config;

import com.datadesign.treegrid.service.TGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TGRegistry {
    private final Map<Class<?>, TGService<?>> registry = new HashMap<>();

    @Autowired
    public TGRegistry(List<TGService<?>> services) {
        for (TGService<?> service : services) {
            registry.put(service.getTargetType(), service);
        }
    }

    public TGService<?> getService(Class<?> clazz) {
        return registry.get(clazz);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> saveAll(Class<T> clazz, List<?> data) {
        TGService<T> service = (TGService<T>) registry.get(clazz);
        return service.saveAll((List<T>) data);
    }
}
