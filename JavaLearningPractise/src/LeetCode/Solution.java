package LeetCode;

import javax.swing.plaf.SliderUI;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1&&nums[0]==0)return 0;

        int res=0;
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)tmp++;
            else if(nums[i]==0){
                //res=res<tmp?tmp:res;
                res=Math.max(res,tmp);
                tmp=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] data=new int[]{1};
        solution.findMaxConsecutiveOnes(data);
    }
}
