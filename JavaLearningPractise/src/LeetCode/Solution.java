package LeetCode;

import javax.swing.plaf.SliderUI;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        if(length==0||length==1)return length;

        int res=0,tmp=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                //字符相等情况
                if(s.charAt(i)==s.charAt(j)){
                    tmp=j-i;
                    res=res>tmp?res:tmp;
                    break;
                }else if(j+1==s.length()){
                    tmp=j-i+1;
                    res=res>tmp?res:tmp;
                    break;
                }else{;}
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String data="abcabcbb";
        solution.lengthOfLongestSubstring(data);
    }
}
