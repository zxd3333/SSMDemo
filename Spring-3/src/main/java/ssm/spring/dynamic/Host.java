package ssm.spring.dynamic;

public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东：出租房子了");
    }
}
