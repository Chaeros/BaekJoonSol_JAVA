// https://www.acmicpc.net/problem/6497
// 전력난, Gold4
// 2023년 8월 29일
// 통과

package MST;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem6497 {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;
        public Node(int start,int end,int cost){
            this.start=start;
            this.end=end;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            if(this.cost<o.cost) return -1;
            else if(this.cost>o.cost) return 1;
            else return 0;
        }
    }
    static int m,n;

    static List<Node> list = new LinkedList<>();
    static int parent[];

    static int find_parent(int x){
        if(parent[x]==x) return x;
        else return find_parent(parent[x]);
    }

    static void union(int a, int b){
        int A = find_parent(a);
        int B = find_parent(b);
        if(A>B) parent[A]=B;
        else parent[B]=A;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m==0 && n==0) break;

            parent = new int[m+1];
            for(int i=1;i<=m;++i){
                parent[i]=i;
            }

            int total=0;
            for(int i=0;i<n;++i){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                total+=cost;

                list.add(new Node(start,end,cost));
            }
            Collections.sort(list);

            int useSum=0;
            for(Node node:list){
                int start = node.start;
                int end = node.end;

                if(find_parent(start)!=find_parent(end)){
                    union(start,end);
                    useSum+=node.cost;
                }
            }

            bw.write(total-useSum+"\n");
            list.clear();
        }
        bw.flush();
        bw.close();
    }
}
