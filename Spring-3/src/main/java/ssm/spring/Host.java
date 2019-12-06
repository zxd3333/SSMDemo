package ssm.spring;

//真实角色--房东
//房东要出租自己的房子，只需要实现出租房子的接口就可以了
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东：出租房子");
    }
}
