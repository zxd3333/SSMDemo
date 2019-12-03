package ssm.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Book implements Serializable {
    private String id;
    private String name;
    private Date createTime;
    private String author;
    private BigDecimal price;
}
