package ssm.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;

//UserController中代码有重复的地方，所以编写工具类
public class JsonUtils {

    //工具类中编写输出时间的代码
    public static String getJson(Object object,String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        //直接输出时间会是一串数字，这里不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,false);
        //这两行是自定义时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //什么都不传入就输出null
        return null;
    }

    //当传入其他不是时间的数据时，执行此方法
    public static String getJson(Object object){
        //方法复用，调用上面的方法，并传入默认值
        //在外部调用此方法的时候，此方法会调用上面的方法
        //而且由于传入的只要不是日期类型的数据，就会return mapper.writeValueAsString(object);
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
}
