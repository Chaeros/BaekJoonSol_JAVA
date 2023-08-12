// https://www.acmicpc.net/problem/2212
// 센서, Gold5
// 2023년 8월 12일
// 통과

package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2212 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int sensor[] = new int[N];
        int gap[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            sensor[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);
        for(int i=1;i<N;++i){
            gap[i]=sensor[i]-sensor[i-1];
        }
        Arrays.sort(gap);

        int sum=0;
        for(int i=1;i<N-K+1;++i){
            sum+=gap[i];
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
