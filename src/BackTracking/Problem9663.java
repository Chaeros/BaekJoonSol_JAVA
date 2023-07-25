// https://www.acmicpc.net/problem/9663
// N-Queen, Gold4
// 2023년 7월 24일

package BackTracking;

import java.util.Scanner;

public class Problem9663 {
    static int resultCount=0;

    static boolean promising(int i,int[] col){
        boolean result=true;
        for(int k=1;k<i;k++){
            if(col[i]==col[k] || Math.abs(col[i]-col[k]) == i-k){
                result=false;
            }
        }
        return result;
    }

    static void n_queens(int i, int[] col){
        int n = col.length-1;
        if(promising(i,col)){
            if(i==n) resultCount++;
            else{
                for(int j=1;j<n+1;++j){
                    col[i+1]=j;
                    n_queens(i+1,col);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();

        int col[] = new int[N+1];
        n_queens(0,col);
        System.out.println(resultCount);
    }
}
