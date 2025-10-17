package com.datadesign.treegrid.util;

import org.reflections.Reflections;

import java.util.Set;

public class TGClassName {
    public Class<?> getClass(String simpleName) throws ClassNotFoundException {
        Reflections reflections = new Reflections("com.datadesign"); // 루트 패키지 기준

        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        for (Class<?> clazz : allClasses) {
            if (clazz.getSimpleName().equals(simpleName)) {
                return clazz;
            }
        }

        throw new ClassNotFoundException("클래스 이름 '" + simpleName + "'에 해당하는 전체 경로를 찾을 수 없습니다.");
    }

}
