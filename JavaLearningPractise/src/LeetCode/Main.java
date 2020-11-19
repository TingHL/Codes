package LeetCode;


public class Main {
    int res=0;
    public void function(String string){
        StringBuilder stringNums=new StringBuilder();
        for(int i=0;i<string.length();i++){
            stringNums.append(string.charAt(i)-'A');
        }
        recur(stringNums.toString(),0);
        System.out.println(res=res>0?res-1:0);
    }

    public void recur(String string,int start){
        if(start==string.length()){
            res++;
            return;
        }

        if(string.charAt(start)=='0'){
            recur(string,start+1);
            return;
        }

        for(int i=start;i<string.length();i++){
            String str=processSubString(string,start,i);
            if(Integer.parseInt(str)>=0&&Integer.parseInt(str)<=25){
                recur(string,i+1);
            }
        }
    }

    public String processSubString(String string,int start,int end){
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<=end;i++){
            sb.append(string.charAt(start));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main =new Main();
        main.function("ABCDBE");
    }
}
