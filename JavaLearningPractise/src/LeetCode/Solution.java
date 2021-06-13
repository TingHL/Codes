package LeetCode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=Solution.firstGenerate(nums,target);
        if(start==nums.length||nums[start]!=target){
            return new int[]{-1,-1};
        }

        int[] ans=new int[]{start,firstGenerate(nums,target+1)-1};
        for(int an:ans){
            System.out.println(an);
        }
        return ans;
    }


    //get the first elements that equals to target in nums.
    public static int firstGenerate(int[] nums,int target){
        //the return result is left
        int left=0,right=nums.length;
        while(left<right){
            int middle=left+(right-left)/2;
            if(nums[middle]>target){
                right=middle-1;
            }else if(nums[middle]<target){
                left=middle+1;
            }else if(nums[middle]==target){
                right=middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
       Solution solution=new Solution();
       int[] data={5,7,7,8,8,10};
       solution.searchRange(data,8);
    }
}