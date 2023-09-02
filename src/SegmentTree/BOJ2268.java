// https://www.acmicpc.net/problem/2268
// 수들의 합7, Gold1
// 2023년 9월 3일
// 통과

package SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2268 {
    static int arr[];
    static long tree[];

//    static long tree_init(int index, int leftVal, int rightVal){
//        if(leftVal==rightVal) return tree[index]=arr[leftVal];
//
//        int mid = leftVal+(rightVal-leftVal)/2;
//        long left = tree_init(index*2,leftVal,mid);
//        long right = tree_init(index*2+1,mid+1,rightVal);
//        return tree[index]=left+right;
//    }

    static long sum_tree(int start,int end,int nodeNum, int leftVal, int rightVal){
        if(start>rightVal || end<leftVal) return 0;
        if(start<=leftVal && end >=rightVal) return tree[nodeNum];

        int mid = leftVal+(rightVal-leftVal)/2;
        long left = sum_tree(start,end,nodeNum*2,leftVal,mid);
        long right = sum_tree(start,end,nodeNum*2+1,mid+1,rightVal);
        return left+right;
    }

    static long modify_tree(int index, int newVal, int nodeNum, int leftVal, int rightVal){
        if(index>rightVal || index<leftVal) return tree[nodeNum];
        if(leftVal==rightVal){
            return tree[nodeNum]=newVal;
        }

        int mid = leftVal+(rightVal-leftVal)/2;
        long left = modify_tree(index,newVal,nodeNum*2,leftVal,mid);
        long right = modify_tree(index,newVal,nodeNum*2+1,mid+1,rightVal);
        return tree[nodeNum] = left+right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        tree = new long[N*4];

        //tree_init(1,0,N);

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int controllNum = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(controllNum==0){
                if(a>b){
                    int temp=a;
                    a=b;
                    b=temp;
                }
//                System.out.println("sum");
//                for(int k=1;k<=4*N-1;++k){
//                    System.out.print(tree[k]+" ");
//                }
//                System.out.println();
                bw.write(sum_tree(a,b,1,1,N)+"\n");
            }
            else{
                modify_tree(a,b,1,1,N);
//                System.out.println("modi");
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
