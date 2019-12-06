package ssm.spring;

//代理角色--中介
//他拿到房东对象后，帮助房东进行出租
//也可以这么想：中介拿到房东的房子后，替房东发布租房的信息
//出租时，中介有自己的附属操作
public class Agency implements Rent {

    private Host host;

    //Spring依赖注入：对象的创建都交给Spring容器去完成
    //依赖注入的本质还是set方法
    //于是这里使用set方法注入对象
    public void setHost(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        look();
        host.rent();
        pay();
    }

    public void look(){
        System.out.println("中介：带你看房子");
    }

    public void pay(){
        System.out.println("中介：问你要中介费");
    }
}
