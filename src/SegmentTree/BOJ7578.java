package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ7578 {

    public static int n;
    public static Map<Integer,Integer> map = new HashMap<>();
    public static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        tree = new long[4*n+1];

        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for ( int i = 1 ; i <= n ; ++i ){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for ( int i = 1 ; i <= n ; ++i ){
            int val = Integer.parseInt(st.nextToken());
            map.put(val,i);
        }

        int arrLen = 0;
        while ( true ){
            if ( n <= Math.pow(2,arrLen) ) break;
            arrLen++;
        }
        arrLen = (int)Math.pow(2,arrLen);

        long count = 0;
        for ( int i = 1 ; i <= n ; ++i ){
            int index = map.get(arr[i]);
            count += segtreeSum(1,arrLen,1,index+1,n);
            updateTree(1,arrLen,1,1,index);
//            printTree();
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }

    public static long segtreeSum(int start, int end , int node, int left, int right){
        if ( right < start || left > end ){
            return 0;
        }
        else if ( left <= start && end <= right ){
            return tree[node];
        }

        int mid = start + (end - start)/2;
        long leftSum = segtreeSum(start,mid,node*2,left,right);
        long rightSum = segtreeSum(mid+1,end,node*2+1,left,right);
        return leftSum + rightSum;
    }

    public static long updateTree(int start, int end, int node, int diff, int index){
        if ( index < start || index > end ){
            return tree[node];
        }
        else if ( index == start && index == end ){
            return tree[node] = diff;
        }
        int mid = start + (end - start)/2;
        long leftUpdate = updateTree(start,mid,node*2,diff,index);
        long rightUpdate = updateTree(mid+1,end,node*2+1,diff,index);
        return tree[node] = leftUpdate + rightUpdate;
    }

    public static void printTree(){
        System.out.println("======================== ");
        for ( long x : tree ){
            System.out.print( x + " ");
        }
        System.out.println();
    }

}
