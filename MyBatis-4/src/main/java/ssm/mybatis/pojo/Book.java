package ssm.mybatis.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Book {
    private String id;
    private String name;
    private Date createTime;
    private String author;
    private BigDecimal price;
}
