package Chapter7;

public class NotInitialization {
    public static void main(String[] args) {
        /**
         *对于静态字段 只有定义这个字段的类才会被初始化 通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不是触发子类的初始化
         * 输出：
         * SuperClass init!
         * 123
         */
//        System.out.println(SubClass.value);

        /**
         * 通过数组定义来引用类，不会触发此类的初始化
         * 输出：无输出
         */
//        SuperClass[] sca=new SuperClass[10];

        /**
         * 非主动使用类字段演示
         */
        System.out.println(ConstClass.HELLOWORLD);

    }
}
