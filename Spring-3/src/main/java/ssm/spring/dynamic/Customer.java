package ssm.spring.dynamic;

public class Customer {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //获得 调用处理程序  的对象
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //设置要代理的角色，传入参数是一个接口，这里的host实现了Rent接口
        proxyInvocationHandler.setObject(host);
        //动态生成代理类
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        //通过代理类的实例调动rent()方法
        proxy.rent();
    }
}
