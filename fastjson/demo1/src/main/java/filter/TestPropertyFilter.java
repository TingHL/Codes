package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;

public class TestPropertyFilter {
    public static void main(String[] args) {
        /**
         * 根据PropertyName与PropertyValue来判断是否序列化
         */
        PropertyFilter propertyFilter=new PropertyFilter() {
            @Override
            public boolean apply(Object object, String name, Object value) {
                System.out.println("---------source="+object);
                System.out.println("---------name="+name);
                System.out.println("---------value="+value);
                System.out.println("");

                //属性是id并且大于等于100时进行序列化
                if("id".equals(name)){
                    long id=((Long)value).longValue();
                    return id>=100;
                }
                return false;
            }
        };

        User user=new User();
        user.setId(9L);
        user.setName("哔哩哔哩");

//        序列化的时候传入filter
        String jsonString= JSON.toJSONString(user,propertyFilter);
        System.out.println("序列化，id=9："+jsonString+"\n");

        user.setId(200L);
        jsonString=JSON.toJSONString(user,propertyFilter);
        System.out.println("序列化，id=200L"+jsonString+"\n");
    }
}
