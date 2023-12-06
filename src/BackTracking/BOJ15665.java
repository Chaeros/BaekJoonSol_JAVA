// https://www.acmicpc.net/problem/15665
// N과 M(11), Silver2
// 2023년 12월 7일
// 통과

package BackTracking;

import java.io.*;
import java.util.*;

public class BOJ15665 {

    static int N,M;
    static int arr[];
    static ArrayList<Integer> list = new ArrayList<>();
    static Set<List<Integer>> set = new HashSet<>();

    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth){
        if(depth==M){

            if(!set.contains(list)){
                set.add(list);

                for(int x:list){
                    sb.append(x+" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=0;i<N;++i){
            list.add(arr[i]);
            dfs(depth+1);
            list.remove(depth);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[st.countTokens()];
        int i=0;
        while(st.hasMoreTokens()){
            arr[i]=Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }
}
