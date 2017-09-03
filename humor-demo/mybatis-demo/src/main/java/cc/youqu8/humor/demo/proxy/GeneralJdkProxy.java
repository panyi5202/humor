package cc.youqu8.humor.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author panyi on 17-9-1.
 * @since V0.0.1
 */
public class GeneralJdkProxy implements InvocationHandler{
    Object target;
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("common jdk proxy start");
        Object resut = method.invoke(target, args);
        System.out.println("common jdk proxy end");
        return resut;
    }
}
