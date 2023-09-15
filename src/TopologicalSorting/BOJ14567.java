// https://www.acmicpc.net/problem/14567
// 선수과목, Gold5
// 2023년 9월 13일
// 통과

package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14567 {
    static int N,M;
    static int inBound[];
    static int semester[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;++i){
            if(inBound[i]==0){
                q.offer(i);
                semester[i]=1;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int x:list.get(now)){
                --inBound[x];
                if(inBound[x]==0){
                    semester[x]=semester[now]+1;
                    q.offer(x);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inBound = new int[N+1];
        semester = new int[N+1];
        for(int i=0;i<=N;++i) list.add(new ArrayList<>());

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
            ++inBound[B];
        }

        topology_sort();

        for(int i=1;i<=N;++i){
            bw.write(semester[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
