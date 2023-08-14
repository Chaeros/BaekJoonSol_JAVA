// https://www.acmicpc.net/problem/10974
// 모든 순열, Silver3
// 2023년 8월 13일
// 통과

package Permutation;

import java.io.*;

public class Problem10974 {
    static boolean check[];
    static int result[];
    static int R;
    static void dfs(int L){
        if(L==R){
            for(int i=0;i<R;++i){
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }
        else{
            for(int i=0;i<R;++i){
                if(!check[i]){
                    result[L]=i+1;
                    check[i]=true;
                    dfs(L+1);
                    check[i]=false;
                }
            }
        }
    }

    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        R=N;

        check=new boolean[N+1];
        result=new int[N+1];

        dfs(0);
    }
}