package ssm.spring.pojo;

public class Student {

    private String name;

    public Student(){
        System.out.println("无参构造");
    }

    public Student(String name){
        System.out.println("带参构造");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
