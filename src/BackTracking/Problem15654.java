// https://www.acmicpc.net/problem/15654
// N과 M(5), Silver3
// 2023년 8월 18일
// 통과

package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654{
    static int N,M;
    static int result[];
    static int arr[];
    static boolean visited[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int depth) throws IOException {
        if(depth==M+1){
            for(int i=1;i<M+1;++i){
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            bw.flush();
        }
        else{
            for(int i=1;i<=N;++i){
                if(!visited[i]){
                    visited[i]=true;
                    result[depth]=arr[i-1];
                    dfs(depth+1);
                    visited[i]=false;
                }
            }
        }

    }
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result=new int[M+1];
        visited=new boolean[N+1];

        dfs(1);

        bw.close();
    }
}