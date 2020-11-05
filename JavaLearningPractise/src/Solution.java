class Solution {
    public String addStrings(String num1, String num2) {
        if("0".equals(num1))return num2;
        if("0".equals(num2))return num1;

        int i=num1.length()-1,j=num2.length()-1,carry=0;
        StringBuilder res=new StringBuilder();
        while(i>=0&&j>=0){
            int tmp=carry+num1.charAt(i--)-'0'+num2.charAt(j--)-'0';
            carry=tmp/10;
            tmp=tmp%10;
            res.insert(0,tmp);
        }

        while(i>=0){
            int tmp=carry+num1.charAt(i--)-'0';
            carry=tmp/10;
            tmp=tmp%10;
            res.insert(0,tmp);
        }
        while(j>=0){
            int tmp=carry+num2.charAt(j--)-'0';
            carry=tmp/10;
            tmp=tmp%10;
            res.insert(0,tmp);
        }

        if(carry!=0)res.insert(0,carry);
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.addStrings("408","5"));
    }
}