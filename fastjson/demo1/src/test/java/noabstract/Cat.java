package noabstract;

public class Cat extends Animal{
    public String flag="Cat";

    public void eat(){
        System.out.println("Cat eat");
    }

    public static void main(String[] args) {
        Animal animal=new Cat();
        //方法是会调用具体的类的方法
        animal.eat();
        //属性的话，会根据Animal 这个声明去调用
        System.out.println(animal.flag);
    }
}
