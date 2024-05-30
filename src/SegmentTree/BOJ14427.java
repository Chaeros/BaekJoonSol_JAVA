package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14427 {
    public static Node arr[];
    public static Node tree[];

    public static class Node{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new Node[n+1];
        tree = new Node[4*n];

        st = new StringTokenizer(br.readLine());
        for ( int i = 1 ; i <= n ; ++i ){
            arr[i] = new Node(i,Integer.parseInt(st.nextToken()));
        }
        initTree(1,n,1);

        int t = Integer.parseInt(br.readLine());
        for ( int i = 0 ; i < t ; ++i ){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if ( command == 1 ){
                int index = Integer.parseInt(st.nextToken());
                int newValue = Integer.parseInt(st.nextToken());
                updateTree(1,n,1,index,newValue);
            }
            else if ( command == 2 ){
                bw.write(tree[1].index+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static Node merge(Node left, Node right){
        if ( left.value < right.value ){
            return left;
        }
        else if ( left.value > right.value ){
            return right;
        }
        else if ( left.value == right.value ){
            if ( left.index < right.index ){
                return left;
            }
            return right;
        }
        return null;
    }

    public static Node initTree(int start, int end, int node){
        if ( start == end ){
            return tree[node] = arr[start];
        }

        int mid = ( start + end ) / 2;
        Node leftMinVal = initTree(start,mid,node*2);
        Node rightMinVal = initTree(mid+1,end,node*2+1);
        return tree[node] = merge(leftMinVal,rightMinVal);
    }

    public static Node updateTree(int start, int end, int node, int index, int newValue ){
        if ( index < start || index > end ){
            return tree[node];
        }
        else if ( start == end ){
            tree[node].value = newValue;
            return tree[node];
        }

        int mid = ( start + end ) / 2;
        Node left = updateTree(start,mid,node*2,index,newValue);
        Node right = updateTree(mid+1, end, node*2+1,index,newValue);
        return tree[node] = merge(left,right);
    }


}
