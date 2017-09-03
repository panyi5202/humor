package cc.youqu8.humor.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author panyi on 17-9-1.
 * @since V0.0.1
 */
public class GeneralCglibProxy implements MethodInterceptor{
    public Object bind(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("General Cglib Proxy start");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("General Cglib Proxy end");
        return result;
    }
}
