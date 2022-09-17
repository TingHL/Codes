package deserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;

import java.util.HashMap;
import java.util.Map;

public class TestExtraProcessor {
    public static class VO{
        private int id;
        private Map<String,Object> attributes=new HashMap<String,Object>();

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }

        public void setAttributes(Map<String, Object> attributes) {
            this.attributes = attributes;
        }

        @Override
        public String toString() {
            return "VO{" +
                    "id=" + id +
                    ", attributes=" + attributes +
                    '}';
        }
    }

    public static void main(String[] args) {
        /**
         * 用于处理多余的字段 反序列化
         */
        ExtraProcessor processor=new ExtraProcessor() {
            @Override
            public void processExtra(Object object, String key, Object value) {
                VO vo=(VO)object;
                vo.getAttributes().put(key,value);
            }
        };

        VO vo= JSON.parseObject("{\"id\":123,\"name\":\"abc\",\"name2\":\"abcd\"}",VO.class,processor);
        System.out.println(vo.toString());
    }
}
