package com.example.tongji.utils;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-08-01  17:37
 */
public class DomainUtils {


    public String getTableName() {
        Type type1 = this.getClass().getGenericSuperclass();
        boolean b = type1 instanceof ParameterizedType;

        if (type1 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type1;
            final Type[] types = parameterizedType.getActualTypeArguments();
            String tableName = null;
            for (final Type type : types) {
                final Annotation annotation = ((Class) type).getAnnotation(Document.class);
                if (annotation == null) {
                    continue;
                }
                tableName = ((Document) annotation).collection();
                break;
            }
            return tableName;
        }

        return null;
    }

    public static String getTableName(Class clazz) {
        Document annotation = (Document) clazz.getAnnotation(Document.class);
        return annotation.collection();
    }
}
