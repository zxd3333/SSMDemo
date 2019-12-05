package ssm.spring;

public class Customer {
    public static void main(String[] args) {
        //一般情况下，我们找到房东，调用它租房的方法即可
        Host host = new Host();
        host.rent();

        //通过中介租房子
        Agency agency = new Agency(host);
        agency.rent();
    }
}
