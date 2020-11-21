package LeetCode;

import javax.swing.plaf.SliderUI;

class Solution {
    public int strToInt(String string) {
        String str=string.trim();
        boolean sign=true;
        int i=0;
        StringBuilder sb=new StringBuilder();


        if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
            while(i<str.length()&&str.charAt(i)<='9'&&str.charAt(i)>='0'){
                sb.append(str.charAt(i));
                ++i;
            }
        }else if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            if(i+1<str.length()&&str.charAt(i+1)<='9'&&str.charAt(i+1)>='0'){
                if(str.charAt(i)=='-')sign=false;
                i++;
                while(i<str.length()&&str.charAt(i)<='9'&&str.charAt(i)>='0'){
                    sb.append(str.charAt(i));
                    i++;
                }
            }else return 0;
        }else return 0;


        long num=Long.parseLong(sb.toString());
        if(!sign)num=-num;
        if(num<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        if(num>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String data=" ";
        solution.strToInt(data);
    }
}
