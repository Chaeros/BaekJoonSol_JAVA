// https://www.acmicpc.net/problem/1182
// 부분수열의 합, Silver2
// 2023년 7월 31일
// 통과

package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1182 {

    static int N,S;
    static int count=0;
    static LinkedList<Integer> list;

    static void dfs(int depth,int val){
        if(depth==N){
            if(val==S){
                count++;
                return;
            }
        }
        else {
            dfs(depth + 1, val + list.get(depth));
            dfs(depth + 1, val);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0,0);
        if(S==0) System.out.println(count-1);
        else System.out.println(count);
    }
}