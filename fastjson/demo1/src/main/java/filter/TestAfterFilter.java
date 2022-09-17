package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.AfterFilter;

public class TestAfterFilter {
    public static void main(String[] args) {
        User user=new User();
        user.setId(9L);
        user.setName("bilili");

        String jsonString= JSON.toJSONString(user);
        System.out.println("普通序列化:"+jsonString+"\n");

        /**
         * AfterFilter 序列化时在最后添加内容
         */
        AfterFilter afterFilter=new AfterFilter() {
            @Override
            public void writeAfter(Object object) {
                User user=(User)object;
                System.out.println("----------User.id="+user.getId()+" "+"User.name="+user.getName()+"\n");
                user.setName(user.getName()+"$$$");
            }
        };

        jsonString=JSON.toJSONString(user,afterFilter);
        System.out.println("AfterFilter序列化："+jsonString);
        System.out.println(user);
    }
}
