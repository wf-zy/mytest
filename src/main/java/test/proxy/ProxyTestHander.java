package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTestHander implements InvocationHandler {
    Object object;

    public ProxyTestHander(Object o) {
        this.object = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=============动态代理================");
        return method.invoke(object,args);
    }
}
