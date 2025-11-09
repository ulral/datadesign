package com.datadesign.treegrid.util;

import jakarta.persistence.Entity;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class TGReflections {
    @Value("${common.base-package}")
    private String basePackage;

    public Class<?> getClass(String simpleName) throws ClassNotFoundException {
        Reflections reflections = new Reflections(basePackage); // 루트 패키지 기준

        Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(Entity.class);
        for (Class<?> clazz : allClasses) {
            if (clazz.getSimpleName().equals(simpleName)) {
                return clazz;
            }
        }

        throw new ClassNotFoundException("클래스 이름 '" + simpleName + "'에 해당하는 전체 경로를 찾을 수 없습니다.");
    }

}
