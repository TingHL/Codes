public class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=toBits(i);
        }
        return ans;
    }

    private int toBits(int num){
        int ans=0;
        while(num!=0){
            if(num%2!=0){
                ans++;
            }
            num=num>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="a,b,c,,";
        String[] ary=str.split(",");
        System.out.println(ary.length);
    }
}
