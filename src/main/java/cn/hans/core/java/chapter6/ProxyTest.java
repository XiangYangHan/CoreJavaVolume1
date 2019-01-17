package cn.hans.core.java.chapter6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new TraceHandler(1);
        Object proxyInstance = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
        proxyInstance.toString();

        Object[] objects = new Object[1000];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, new TraceHandler(i + 1));
        }

        Integer key =(int)(Math.random() * objects.length);
        int result = Arrays.binarySearch(objects, key);
        if (result >=0 ) {
            System.out.println("objects[" + result + "] = " + objects[result]);
        }
    }

}

class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (null != args) {
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(args[i]);
            }
        }
        System.out.println(")");
//        ReflectionTest.printClass(proxy.getClass());
        return method.invoke(target, args);
    }
}
