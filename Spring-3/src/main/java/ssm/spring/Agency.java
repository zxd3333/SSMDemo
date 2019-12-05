package ssm.spring;

//代理角色--中介
//他拿到房东对象后，帮助房东进行出租
//出租时，中介有自己的附属操作
public class Agency implements Rent {

    private Host host;

    public Agency(){

    }
    public Agency(Host host){
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
