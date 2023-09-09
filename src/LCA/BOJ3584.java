// https://www.acmicpc.net/problem/3584
// 가장 가까운 공통 조상, Gold4
// 2023년 9월 9일
// 통과

package LCA;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ3584 {

    static int parent[];
    static Stack<Integer> stackA = new Stack<>();
    static Stack<Integer> stackB = new Stack<>();

    static int find_parent(int x, Stack<Integer> stack){
        stack.push(x);
        if(x==parent[x]) return x;
        else return find_parent(parent[x],stack);
    }

    static int find_LCA(){
        int lca=0;
        while(!stackA.isEmpty() && !stackB.isEmpty()){
            int aVal = stackA.pop();
            int bVal = stackB.pop();
            if(aVal==bVal){
                lca=aVal;
            }
            else break;
        }
        return lca;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;++t){
            int N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            stackA.clear();
            stackB.clear();
            for(int i=1;i<=N;++i){
                parent[i]=i;
            }

            for(int n=0;n<N-1;++n){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parent[B]=A;
            }

            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            find_parent(A,stackA);
            find_parent(B,stackB);

            bw.write(find_LCA()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
