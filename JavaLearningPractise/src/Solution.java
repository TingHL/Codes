import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        if(s.length()==1)return 1;
        int left,right,currentLength=0,length=s.length()-1;
        Set<Character> set=new HashSet<Character>();
        for(left=0;left<=length;left++){
            set.clear();
            for(right=left;right<=length;right++){
                if(set.contains(s.charAt(right))){
                    if(set.size()>currentLength){
                        currentLength=set.size();
                        break;
                    }
                }else{
                    set.add(s.charAt(right));
                }
            }
        }
        return currentLength;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.lengthOfLongestSubstring("ab");
    }
}