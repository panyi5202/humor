package cc.youqu8.humor.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author panyi on 17-9-1.
 * @since V0.0.1
 */
public class ProxyUtil {
    public static void main(String[] args) throws IOException {
        // genarate(FootBall.class,"FootBallProxy2");
        // testJdkProxy();
        testCglibProxy();
    }

    public static void testCglibProxy() {
        FootBall fb = new FootBall();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FootBall.class);
        enhancer.setCallback(new ProxyUtil().new CglibProxy());
        FootBall ball = (FootBall) enhancer.create();
        ball.play();
    }

    class CglibProxy implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("cglib start");
            methodProxy.invokeSuper(o, objects);
            System.out.println("cglib end");
            return null;
        }
    }

    public static void testJdkProxy() {
        Ball ro = new FootBall();
        Ball o = (Ball) Proxy.newProxyInstance(FootBall.class.getClassLoader(), FootBall.class.getInterfaces(), new
                InvocationHandlerImpl(ro));
        o.play();

    }

    static class InvocationHandlerImpl implements InvocationHandler {
        Ball o;

        public InvocationHandlerImpl(Ball o) {
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("start");
            method.invoke(o, args);
            System.out.println("end");
            return null;
        }
    }

    public static void genarate(Class clazz, String proxyName) throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = clazz.getResource(".").getPath();
        System.out.println(path);
        // 保留到硬盘
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path + proxyName + ".class");
            fos.write(bytes);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
    }
}
