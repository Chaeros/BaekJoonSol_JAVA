package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14438 {

    public static int arr[];
    public static int tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tree = new int[4*N+1];

        st = new StringTokenizer(br.readLine());
        for ( int i = 1 ; i <= N ; ++i ){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for ( int i = 0 ; i < M ; ++i ){

        }
    }

    public static int merge(int left, int right){
        if ( left < right) {
            return left;
        }
        return right;
    }

    public static int initTree(int start, int end, int node){
        if ( start == end ){
            return tree[node] = arr[start];
        }

        int mid = (start+end)/2;
        int left = initTree(start,mid,node*2);
        int right = initTree(mid+1,end,node*2+1);
        return tree[node] = merge(left,right);
    }

    public static int update(int start, int end, int node, int index, int newValue){
        if ( index < start || end < index ){
            return Integer.MAX_VALUE;
        }
        else if ( start == end ){
            return tree[node] = newValue;
        }

        int mid = (start+end)/2;
        int left = update(start,mid,node*2,index,newValue);
        int right = update(mid+1,end,node*2+1,index,newValue);
        return tree[node] = merge(left,right);
    }

//    public static int getMinVal(int start, int end, int node, int nodeLeft, int nodeRight){
////        if ( )
//    }
}
