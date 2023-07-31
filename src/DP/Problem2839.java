// https://www.acmicpc.net/problem/2839
// 설탕배달, Silver4
// 2023년 7월 29일
// 통과

package DP;

import java.util.Scanner;

public class Problem2839 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();

        int d[]=new int[5001];
        d[1]=-1;
        d[2]=-1;
        d[3]=1;
        d[4]=-1;
        d[5]=1;

        for(int i=6;i<5001;++i){
            if(d[i-3]==-1 && d[i-5]==-1){
                d[i]=-1;
            }
            else if(d[i-3]==-1 && d[i-5]!=-1){
                d[i]=d[i-5]+1;
            }
            else if(d[i-3]!=-1 && d[i-5]==-1){
                d[i]=d[i-3]+1;
            }
            else if(d[i-3]!=-1 && d[i-5]!=-1){
                d[i]=Math.min(d[i-3]+1,d[i-5]+1);
            }
        }

        System.out.println(d[N]);

    }
}
