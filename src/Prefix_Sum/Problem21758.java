package Prefix_Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21758 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int graph[] = new int[N];
        for(int i=0;i<N;++i) graph[i]=Integer.parseInt(st.nextToken());

        int prefix_sum[] = new int[N];
        prefix_sum[0]=graph[0];
        for(int i=1;i<N;++i){
            prefix_sum[i]=prefix_sum[i-1]+graph[i];
        }

        int maxSum=0;
        for(int i=1;i<N-1;++i){
            if(maxSum<prefix_sum[N-1]-prefix_sum[0]-graph[i]+prefix_sum[N-1]-prefix_sum[i])
                maxSum=prefix_sum[N-1]-prefix_sum[0]-graph[i]+prefix_sum[N-1]-prefix_sum[i];
            if(maxSum<prefix_sum[N-1]-graph[N-1]-graph[i]+prefix_sum[i]-graph[i])
                maxSum=prefix_sum[N-1]-graph[N-1]-graph[i]+prefix_sum[i]-graph[i];
            if(maxSum<prefix_sum[i]-graph[0]+prefix_sum[N-2]-prefix_sum[i-1])
                maxSum=prefix_sum[i]-graph[0]+prefix_sum[N-2]-prefix_sum[i-1];
        }
        System.out.println(maxSum);
    }
}