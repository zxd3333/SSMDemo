package ssm.spring.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//调用处理程序
//用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object object;

    //依赖注入：注入接口对象
    public void setObject(Object object) {
        this.object = object;
    }

    //获得代理实例
    //调用Proxy(代理类)的newProxyInstance(ClassLoader，interfaces，InvocationHandler)方法获得代理实例的对象
    //ClassLoader:本类的加载器
    //interfaces:调用的哪个接口，通过object.getClass().getInterfaces()获得真实角色实现的接口
    //InvocationHandler:本类实现了InvocationHandler接口，所以写this
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    //实现InvocationHandler重写的方法，作用是处理代理实例，并返回结果
    //要处理代理实例，就首先需要有代理实例，所以通过上面的getProxy()获得代理实例
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用method中的invoke()方法，调用object接口中的方法，获得结果
        Object result = method.invoke(object, args);
        return result;
    }
}
