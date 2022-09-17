package deserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;

import java.lang.reflect.Type;

public class TestExtraTypeProvider implements ExtraProcessor, ExtraTypeProvider {

    @Override
    public void processExtra(Object object, String key, Object value) {
        TestExtraProcessor.VO vo=(TestExtraProcessor.VO)object;
        vo.getAttributes().put(key,value);
    }

    @Override
    public Type getExtraType(Object object, String key) {
        if("value".equals(key)){
            return int.class;
        }
        return null;
    }

    public static void main(String[] args) {
        ExtraProcessor processor=new TestExtraTypeProvider();
        TestExtraProcessor.VO vo=JSON.parseObject("{\"id\":123,\"value\":\"123456\"}", TestExtraProcessor.VO.class, processor);
        System.out.println(vo.toString());
    }
}
