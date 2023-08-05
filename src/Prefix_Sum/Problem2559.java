// https://www.acmicpc.net/problem/2559
// 수열 , Silver3
// 2023년 8월 1일
// 통과

package Prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2559 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[]= new int[N+1];
        int prefix_sum[]=new int[N+1];

        for(int i=1;i<N+1;++i){
            arr[i]=Integer.parseInt(st.nextToken());
            prefix_sum[i]=prefix_sum[i-1]+arr[i];
        }
        int maxVal=-(int)1e9;
        for(int i=0;i<=N-K;++i){
            if(maxVal<prefix_sum[K+i]-prefix_sum[i]){
                maxVal=prefix_sum[K+i]-prefix_sum[i];
            }
        }
        System.out.println(maxVal);
    }
}
