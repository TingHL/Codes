package LeetCode;

import javax.swing.plaf.SliderUI;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        int currentNum=Integer.MAX_VALUE;
        int times=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==currentNum&&times<=1){
                nums[index]=nums[i];
                index++;
                times++;
            }else if(nums[i]==currentNum&&times>=2){

            }else if(nums[i]!=currentNum){
                nums[index]=nums[i];
                times=1;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] data={1,1,1,2,2,3};
        solution.removeDuplicates(data);
    }
}
