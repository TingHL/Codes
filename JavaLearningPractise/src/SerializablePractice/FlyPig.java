package SerializablePractice;

import java.io.Serializable;

public class FlyPig implements Serializable {
    private static String AGE="26";
    private String name;
    private String color;
    transient private String car;

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='"+AGE+'\''+
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public static void setAGE(String AGE) {
        FlyPig.AGE = AGE;
    }

    public static String getAGE() {
        return AGE;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCar() {
        return car;
    }
}
