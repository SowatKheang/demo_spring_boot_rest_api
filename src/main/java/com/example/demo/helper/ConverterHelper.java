package com.example.demo.helper;

import java.util.*;

/**
 * @ConverterHelper
 */
public class ConverterHelper<T> {
    
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

    public static <T> T castObject(Object obj, Class<T> clazz) {
        T result = null;
        if (obj != null) {
            result = clazz.cast(obj);
        }
        return result;
    }

}
