package net.czqu.taskmaster.utils;

import java.util.Map;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 22:06
 **/
public class ObjectUtil {
    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new org.apache.commons.beanutils.BeanMap(obj);
    }
}
