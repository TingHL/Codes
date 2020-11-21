package LeetCode;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static ArrayList<Integer> tmp=new ArrayList<>();
    public static long maxInversions(List<Integer> arr){
        int res=recur(arr,0);
        return res;
    }

    public static int recur(List<Integer> arr,int index){
        if(tmp.size()==3)return 1;
        int res=0;
        for(int i=index;i<arr.size();i++){
            if(tmp.size()==0){
                tmp.add(arr.get(i));
                res+=recur(arr,i+1);
                tmp.remove(tmp.size()-1);
            }else{
                if(tmp.get(tmp.size()-1)<arr.get(i)){
                    ;
                }else if(tmp.get(tmp.size()-1)>arr.get(i)){
                    tmp.add(arr.get(i));
                    res+=recur(arr,i+1);
                    tmp.remove(tmp.size()-1);
                }else{;}
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> data=new LinkedList<>();
        data.add(4);
        data.add(1);
        data.add(3);
        data.add(2);
        data.add(5);
        long res=maxInversions(data);
        System.out.println(res);
    }
}
