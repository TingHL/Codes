package LeetCode;

import java.util.*;

class Solution {
    Stack<Character> stackLetter=new Stack<>();
    Stack<Integer> stackDigit=new Stack<>();

    public String decodeString(String s){
        int length=s.length();
        StringBuilder sb=null;

        for(int i=0;i<length;){
            char c=s.charAt(i);

            if(c<='9'&&c>='0'){
                sb=new StringBuilder();
                while(c<='9'&&c>='0'){
                    sb.append(c);
                    c=s.charAt(++i);
                }
                stackDigit.push(Integer.valueOf(sb.toString()));
            }else if(c==']'){
                sb=new StringBuilder();
                while(!stackLetter.isEmpty()&&stackLetter.peek()!='['){
                    sb.insert(0,stackLetter.pop());
                }
                stackLetter.pop();
                for(int j=0;j<stackDigit.pop();j++){
                    for(int k=0;k<sb.length();k++){
                        stackLetter.push(sb.charAt(k));
                    }
                }
                i++;
            }else{
                stackLetter.push(c);
                i++;
            }
        }

        StringBuilder ans=new StringBuilder();
        while(!stackLetter.isEmpty()){
            ans.insert(0,stackLetter.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        while(true){
            System.out.println((1));
        }
    }
}