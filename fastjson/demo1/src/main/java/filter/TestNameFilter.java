package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PascalNameFilter;

public class TestNameFilter {
    public static void main(String[] args) {
        User user=new User();
        user.setId(9L);
        user.setName("bilili");

        String jsonString= JSON.toJSONString(user);
        System.out.println("普通序列化:"+jsonString+"\n");

        /**
         * 修改key，如果需要修改Key，process返回值即可
         */
        NameFilter nameFIlter=new NameFilter(){
            @Override
            public String process(Object object, String name, Object value) {
                System.out.println("----------------object=" + object);
                System.out.println("----------------name=" + name);
                System.out.println("----------------value=" + value);
                System.out.println("");

                //属性是id时修改id的名字
                if("id".equals(name)){
                    return name+"$";
                }
                return name;
            }
        };

        jsonString=JSON.toJSONString(user,nameFIlter);
        System.out.println("NameFilter序列化："+jsonString+"\n");

        //fastjson内置一个PascalNameFilter，用于输出将首字符大写的Pascal风格
        jsonString=JSON.toJSONString(user,new PascalNameFilter());
        System.out.println("PascalNameFilter序列化："+jsonString+"\n");
    }
}
