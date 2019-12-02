package ssm.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;

    //研究resultMap中的collection时，注释这一行,不然输出结果中会有teacher=null
    //而我们通过老师id查询所有信息时会输出老师的信息，于是这一属性就显得多余了
    //private Teacher teacher;
}
