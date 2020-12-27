package LeetCode;

import java.util.*;

class Solution {
    StringBuilder ans=new StringBuilder();

    public String reformatNumber(String number) {
        number=number.replace(" ","");
        number=number.replace("-","");
        System.out.println("number replace:"+number);
        char[] cArray=number.toCharArray();

        if(cArray.length<=4){
            fourLength(cArray,0,cArray.length);
        }else{
            int i=0;
            while(cArray.length-i>4){
                ans.append(cArray[i++]);
                ans.append(cArray[i++]);
                ans.append(cArray[i++]);
                ans.append("-");
            }
            fourLength(cArray,i,cArray.length);
        }

        return ans.toString();
    }


    public void fourLength(char[] array,int start,int end){
        if(end-start==2)ans.append(array,start,2);
        if(end-start==3)ans.append(array,start,3);
        if(end-start==4){
            ans.append(array,start,2);
            ans.append('-');
            ans.append(array,start+2,2);
        }
    }

    public static void main(String[] args) {
       Solution solution=new Solution();
        System.out.println(solution.reformatNumber("1-23-45 6"));
    }
}