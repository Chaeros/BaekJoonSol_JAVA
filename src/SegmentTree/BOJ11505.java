// https://www.acmicpc.net/problem/11505
// 구간 곱 구하기, Gold1
// 2023년 9월 3일
// 통과

package SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11505 {

    static int arr[];
    static long tree[];
    static long divideVal=1000000007L;

    static long init_tree(int index, int nodeLeft, int nodeRight){
        if(nodeLeft==nodeRight) return tree[index]=arr[nodeLeft];

        int mid = (nodeLeft+nodeRight)/2;
        long left = init_tree(index*2,nodeLeft,mid);
        long right = init_tree(index*2+1,mid+1,nodeRight);
        return tree[index]=(left*right)%divideVal;
    }

    static long modify_tree(int index, int newVal, int node, int nodeLeft, int nodeRight){
        if(index<nodeLeft || index>nodeRight) return tree[node];
        if(nodeLeft==nodeRight) return tree[node]=newVal;

        int mid = (nodeLeft+nodeRight)/2;
        long left = modify_tree(index,newVal,node*2,nodeLeft,mid);
        long right = modify_tree(index,newVal,node*2+1,mid+1,nodeRight);
        return tree[node]=(left*right)%divideVal;

    }

    static long query_tree(int start, int end, int node, int nodeLeft, int nodeRight){
        if(start>nodeRight || end<nodeLeft) return 1;
        if(start<=nodeLeft && nodeRight<=end) return tree[node];

        int mid = (nodeLeft+nodeRight)/2;
        long left = query_tree(start,end,node*2,nodeLeft,mid);
        long right = query_tree(start,end,node*2+1,mid+1,nodeRight);
        return (left*right)%divideVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new long[4*N];
        
        for(int i=1;i<=N;++i){
            arr[i]=Integer.parseInt(br.readLine());
        }

        init_tree(1,1,N);

//        for(int i=1;i<=4*N-1;++i){
//            System.out.print(tree[i]+" ");
//        }
//        System.out.println();

        for(int i=0;i<M+K;++i){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(command==1){
                modify_tree(a,b,1,1,N);

//                System.out.println("modify");
//                for(int k=1;k<=4*N-1;++k){
//                    System.out.print(tree[k]+" ");
//                }
//                System.out.println();
            }
            else{
                bw.write(query_tree(a,b,1,1,N)+"\n");
//                System.out.println("print");
//                for(int k=1;k<=4*N-1;++k){
//                    System.out.print(tree[k]+" ");
//                }
//                System.out.println();
            }


        }
        bw.flush();
        bw.close();
    }
}
