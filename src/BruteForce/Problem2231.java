// https://www.acmicpc.net/problem/2231
// 분해합, Bronze2
// 2023년 8월 6일
// 통과

package BruteForce;

import java.io.*;

public class Problem2231 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());
        int result=Integer.MAX_VALUE;

        for(int i=N;i>0;--i){
            int temp=i;
            int sum=0;
            while(temp>0){
                sum+=(temp%10);
                temp/=10;
            }
            if(i+sum==N){
                if(result>i){
                    result=i;
                }
            }
        }
        if(result!=Integer.MAX_VALUE) bw.write(result+"\n");
        else bw.write(0+"\n");
        bw.flush();
        bw.close();
    }
}
