package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

public class TestValueFilter {
    public static void main(String[] args) {
        User user=new User();
        user.setId(9L);
        user.setName("bilili");

        String jsonString= JSON.toJSONString(user);
        System.out.println("普通序列化:"+jsonString+"\n");

        /**
         * 修改Value
         */
        ValueFilter filter=new ValueFilter(){
            @Override
            public Object process(Object object, String name, Object value) {
                System.out.println("----------------object=" + object);
                System.out.println("----------------name=" + name);
                System.out.println("----------------value=" + value);
                System.out.println("");
                // 属性是id时修改id的值
                if ("id".equals(name)) {
                    long id = ((Long) value).longValue();
                    return id + "$";
                }
                return value;
            }
        };

        jsonString=JSON.toJSONString(user,filter);
        System.out.println("ValueFilter序列化:"+jsonString+"\n");
    }
}
