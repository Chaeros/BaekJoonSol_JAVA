// https://www.acmicpc.net/problem/9466
// 텀 프로젝트, Gold3
// 2023년 9월 24일
// 통과

package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9466{

    static int list[];
    static boolean visited[];
    static boolean tempVisited[];
    static int originVal=0;
    static int studentSum=0;
    static List<Integer> belongedStudents = new ArrayList<>();

    static void dfs(int x,int count){
        visited[x]=true;
        int next = list[x];
        belongedStudents.add(x);

        if(!visited[next]) dfs(next,count+1);
        else{
            if(belongedStudents.contains(next)){
                studentSum+=belongedStudents.size()-belongedStudents.indexOf(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;++t){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            visited = new boolean[n+1];
            list = new int[n+1];
            studentSum=0;
            for(int i=1;i<=n;++i){
                list[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;++i){
                originVal=i;
                if(!visited[i]){
                    visited[i]=true;
                    tempVisited = visited;
                    dfs(i,1);
                }
                belongedStudents.clear();
            }

            bw.write(n-studentSum+"\n");
        }
        bw.flush();
        bw.close();
    }
}