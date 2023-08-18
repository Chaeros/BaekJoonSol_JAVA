// https://www.acmicpc.net/problem/15652
// N과 M(4), Silver3
// 2023년 8월 18일
// 통과

package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15652{
    static int N,M;
    static int result[];

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
                if(result[depth-1]<=i){
                    result[depth]=i;
                    dfs(depth+1);
                }
            }
        }

    }
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result=new int[M+1];

        dfs(1);

        bw.close();
    }
}