package ssm.spring;

public class Customer {
    public static void main(String[] args) {
        //一般情况下，我们找到房东，调用他的租房方法即可
        Host host = new Host();
        host.rent();

        //静态代理模式--通过中介租房子
        //首先需要一个房东，他要出租自己的房子
        Host h = new Host();
        //这里中介帮他发布信息
        Agency agency = new Agency();
        agency.setHost(h);
        //然后我们找到中介，再调用中介的租房方法，在Agency类中可以看出，中介的租房方法本质上还是房东租房
        //但是中介的租房方法还有自己的方法，也就是中间商赚差价的意思，也可以理解成代理费。
        agency.rent();
    }
}
