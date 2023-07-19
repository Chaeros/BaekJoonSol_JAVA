// https://www.acmicpc.net/problem/9251
// LCS, Gold5
// 2023년 7월 18일

package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem9251 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1=br.readLine();
        String str2=br.readLine();

        int d[][] = new int[str2.length()+1][str1.length()+1];
        int maxVal=0;

        for(int i=0;i<str2.length();++i){
            for(int j=0;j<str1.length();++j){
                if(str2.charAt(i)==str1.charAt(j)){
                    d[i+1][j+1]=d[i][j]+1;
                }
                else{
                    d[i+1][j+1]=Math.max(d[i][j+1],d[i+1][j]);
                }
                maxVal=(maxVal<d[i+1][j+1])?d[i+1][j+1]:maxVal;
            }
        }
        System.out.println(maxVal);
    }
}
