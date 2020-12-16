package LeetCode;

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)return 0;

        int row=matrix.length;
        int col=matrix[0].length;
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    ans=Math.max(ans,partialArea(matrix,i,j));
                }
            }
        }
        return ans;
    }

    public int partialArea(char[][] matrix,int row,int col){
        int rowEnd=row,colEnd=col;
        for(;rowEnd<matrix.length;rowEnd++){
            if(matrix[rowEnd][col]!='1')break;
        }
        rowEnd--;

        forEnd:for(;colEnd<matrix[0].length;colEnd++){
            for(int i=row;i<=rowEnd;row++){
                if(matrix[i][colEnd]!='1')break forEnd;
            }
        }
        colEnd--;

        return (rowEnd-row+1)*(colEnd-col+1);
    }

    public static void main(String[] args) {
        HashMap<Character,Integer> freq=new HashMap<>();
        freq.put('A',1);
        freq.put('B',2);
        freq.put('C',3);
        freq.put('D',4);
        Set<Map.Entry<Character,Integer>> entrySet=freq.entrySet();
        for(Map.Entry<Character,Integer> entry:entrySet){
            System.out.println(entry);
        }
    }
}