// https://www.acmicpc.net/problem/10868
// 최솟값, Gold1
// 2023년 9월 3일
// 통과

package SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10868 {
    static int arr[];
    static int tree[];

    static int init_tree(int node, int nodeLeft, int nodeRight){
        if(nodeLeft==nodeRight) return tree[node]=arr[nodeLeft];

        int mid = (nodeLeft+nodeRight)/2;
        int left = init_tree(node*2,nodeLeft,mid);
        int right = init_tree(node*2+1,mid+1,nodeRight);
        return tree[node]=Math.min(left,right);
    }

    static int search_minVal(int start, int end, int node, int nodeLeft, int nodeRight){
        if(start>nodeRight || end<nodeLeft) return Integer.MAX_VALUE;
        if(nodeLeft>=start && end>=nodeRight) return tree[node];

        int mid=(nodeLeft+nodeRight)/2;
        int left = search_minVal(start,end,node*2,nodeLeft,mid);
        int right = search_minVal(start,end,node*2+1,mid+1,nodeRight);
        return Math.min(left,right);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new int[4*N];

        for(int i=1;i<=N;++i){
            arr[i]=Integer.parseInt(br.readLine());
        }
        init_tree(1,1,N);

//        for(int i=1;i<=N;++i){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        for(int i=1;i<=4*N-1;++i){
//            System.out.print(tree[i]+" ");
//        }
//        System.out.println();

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(search_minVal(a,b,1,1,N)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
