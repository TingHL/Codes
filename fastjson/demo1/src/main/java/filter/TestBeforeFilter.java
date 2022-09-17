package filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.BeforeFilter;

public class TestBeforeFilter {
    public static void main(String[] args) {
        User user=new User();
        user.setId(9L);
        user.setName("bilili");

        String jsonString= JSON.toJSONString(user);
        System.out.println("普通序列化:"+jsonString+"\n");

        /**
         * BeforeFilter 序列化时在最前添加内容
         */
        BeforeFilter beforeFilter=new BeforeFilter() {
            @Override
            public void writeBefore(Object object) {
                System.out.println("--------object"+object);

                User user=(User) object;
                System.out.println("----------User.id="+user.getId()+" ");
                user.setName(user.getName()+"$$$$");
            }
        };

        jsonString=JSON.toJSONString(user,beforeFilter);
        System.out.println("BeforeFilter序列化:"+jsonString+"\n");
    }
}
