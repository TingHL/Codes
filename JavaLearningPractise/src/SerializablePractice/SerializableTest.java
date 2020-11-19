package SerializablePractice;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws Exception{
        //serializeFlyPig();
        FlyPig flyPig=deserializeFlyPig();
        System.out.println(flyPig.toString());
    }

    private static void serializeFlyPig() throws IOException{
        FlyPig flyPig=new FlyPig();
        flyPig.setCar("black");
        flyPig.setName("naruto");
        flyPig.setCar("0000");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("./flyPig.txt")));
        oos.writeObject(flyPig);
        System.out.println("FlyPig 对象序列化成功");
        oos.close();
    }

    private static FlyPig deserializeFlyPig() throws Exception{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("./flyPig.txt")));
        FlyPig person=(FlyPig)ois.readObject();
        System.out.println("FlyPig 对象反序列化成功！");
        return person;
    }
}
