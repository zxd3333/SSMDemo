package ssm.spring;

//真实角色--房东
//他比较忙碌，没空搭理我们，但是出于某些原因，他要出租自己的房子
//这里只需要实现出租房子的接口就可以了
//可以理解为这个接口是专门给他写的
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东：出租房子");
    }
}
