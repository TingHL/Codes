public class StringSplitPractice {
    public static void main(String[] args) {
        String string=new String("123n1234n");
        String[] arraysString=string.split("n");
        for(int i=0;i<arraysString.length;i++){
            System.out.println(arraysString[i]);
        }
    }
}
