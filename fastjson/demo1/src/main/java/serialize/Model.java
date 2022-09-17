package serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class Model {
    @JSONField(serializeUsing=ModelValueSerializer.class)
    public int value;

    public static class ModelValueSerializer implements ObjectSerializer {
        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName,
                          Type fieldType, int features) throws IOException {
            Integer value=(Integer)object;
            String text=value+"元";
            serializer.write(text);
        }
    }

    public static void main(String[] args) {
        Model model=new Model();
//        对内部静态类的实例化不需要外部实例化的引用
        Model.ModelValueSerializer modelValueSerializer=new ModelValueSerializer();
        model.value=100;
        String Json= JSON.toJSONString(model);
        System.out.println(Json);
    }
}



