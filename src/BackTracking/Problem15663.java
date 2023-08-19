package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem15663{
    static int N,M;
    static int result[];
    static ArrayList<Integer> arr;
    static boolean visited[];

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int depth) throws IOException {
        if(depth==M+1){
            for(ArrayList<Integer> arr:list){
                for(int a:arr){
                }
            }
            for(int i=1;i<M+1;++i){
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            bw.flush();
        }
        else{
            for(int i=1;i<=arr.size();++i){
                if(!visited[i]){
                    visited[i]=true;
                    result[depth]=arr.get(i-1);
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
        arr = new ArrayList<>();
        for(int i=0;i<N;++i){
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            list.add(new ArrayList<>());
        }
        Collections.sort(arr);

        result=new int[M+1];
        visited=new boolean[N+1];

        dfs(1);

        bw.close();
    }
}