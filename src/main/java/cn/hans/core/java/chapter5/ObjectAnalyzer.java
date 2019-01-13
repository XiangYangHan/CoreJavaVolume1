package cn.hans.core.java.chapter5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ObjectAnalyzer {

    private List<Object> visited = new ArrayList<>();

    public String toString(Object object) {
        if (null == object) {
            return "null";
        }
        if (visited.contains(object)) {
            return "...";
        }
        visited.add(object);
        Class<?> cl = object.getClass();
        if (cl == String.class) {
            return (String)object;
        }
        if (cl.isArray()) {
            Class<?> componentType = cl.getComponentType();
            StringBuilder sb = new StringBuilder();
            sb.append(componentType.getName()).append("[]{");
            for (int i = 0; i < Array.getLength(object); i++) {
                Object component = Array.get(object, i);
                if (componentType.isPrimitive()) {
                    sb.append(component);
                } else {
                    sb.append(toString(component));
                }
            }
            sb.append("}");
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cl.getName());
        do {
            sb.append("[");
            Field[] declaredFields = cl.getDeclaredFields();
            cl.getFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                field.isAccessible();
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                sb.append(field.getName()).append("=");
                try {
                    if (field.getType().isPrimitive()) {
                            sb.append(field.get(object));
                    } else {
                        sb.append(toString(field.get(object)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sb.append("]");
            cl = cl.getSuperclass();
        } while (cl != null);
        return sb.toString();
    }
}
