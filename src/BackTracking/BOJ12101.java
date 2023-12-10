// https://www.acmicpc.net/problem/12101
// 1,2,3 더하기 2, Silver1
// 2023년 12월 11일
// 통과

package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12101 {

    static int n,k;

    static String result="";
    static int resultSum=0;
    static int count=0;
    static boolean isEnd=false;

    static void dfs(int depth){
        if(resultSum>n) return;

        if(resultSum==n){
            count++;
            if(count==k){
                System.out.println(result);
                isEnd=true;
            }
            return;
        }

        for(int i=1;i<=3;++i){
            if(depth==0) result+=i;
            else{
                result = result.concat("+");
                result+=i;
            }
            resultSum+=i;
            dfs(depth+1);
            if(isEnd) return;
            if(depth==0) result = result.substring(0,result.length()-1);
            else result = result.substring(0,result.length()-2);
            resultSum-=i;
        }

        if(depth==0) System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dfs(0);
    }
}
