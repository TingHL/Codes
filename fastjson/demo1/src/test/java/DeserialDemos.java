import com.alibaba.fastjson.JSON;

public class DeserialDemos {
    private String id;
    private String demo;
    private boolean at;

    public DeserialDemos() {
    }

    public DeserialDemos(String id, String demo, boolean at) {
        this.id = id;
        this.demo = demo;
        this.at = at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public boolean isAt() {
        return at;
    }

    public void setAt(boolean at) {
        this.at = at;
    }

    @Override
    public String toString() {
        return "DeserialDemos{" +
                "id='" + id + '\'' +
                ", demo='" + demo + '\'' +
                ", at='" + at + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String str="{id:1,demo:2}";
        DeserialDemos demos=JSON.parseObject(str,DeserialDemos.class);
        System.out.println(JSON.parseObject(str,DeserialDemos.class).toString());
        System.out.println(demos.isAt());
        if(demos.isAt()){
            System.out.println();
        }
    }
}
