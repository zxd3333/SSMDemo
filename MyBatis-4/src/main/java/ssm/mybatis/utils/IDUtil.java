package ssm.mybatis.utils;

import org.junit.Test;

import java.util.UUID;

//ID生成工具类
//随机生成ID
public class IDUtil {

    public static String gerId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
