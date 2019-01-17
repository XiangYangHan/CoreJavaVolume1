package cn.hans.core.java.chapter5;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter class name (e.g. java.lang.Date):");
        String name = in.next();

        try {
            Class<?> cl = Class.forName(name);
            Class<?> supercl = cl.getSuperclass();
            String modifier = Modifier.toString(cl.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print("class " + name + " ");
            if (null != supercl/* && supercl != Object.class*/) {
                System.out.print("extends " + supercl.getName() + " ");
            }
            System.out.print("{\n");

            printConstructors(cl);

            printMethods(cl);

            printFields(cl);

            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ReflectionTest(){}

    public static void printConstructors(Class cl) {

        Constructor[] declaredConstructors = cl.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            String name = constructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (null != modifiers && modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName() + " arg" + i);
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl) {

        Method[] declaredMethods = cl.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.print("    ");
            String name = method.getName();
            String modifier = Modifier.toString(method.getModifiers());
            if (null != modifier && modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            String returnType = method.getReturnType().getName();
            System.out.print(returnType + " " + name + "(");
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl) {

        Field[] declaredFields = cl.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.print("    ");
            String modifier = Modifier.toString(field.getModifiers());
            String typeName = field.getType().getName();
            String name = field.getName();
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.println(typeName + " " + name + ";");
        }

    }
}
