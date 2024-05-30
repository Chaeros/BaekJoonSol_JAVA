// https://www.acmicpc.net/problem/11003
// 최솟값 찾기, Platinum5
// 2024년 1월 28일
// 통과

package SegmentTree;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class BOJ11003 {
//
//    public static int N,L;
//    public static int tree[];
//    public static int arr[];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        L = Integer.parseInt(st.nextToken());
//        tree = new int[N*4+1];
//        arr = new int[N+1];
//
//        st = new StringTokenizer(br.readLine());
//        for ( int i = 1 ; i <= N ; ++i ){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        initTree(1,N,1);
////        printMap();
//        for ( int i =1 ; i <= N ; ++i ){
//
//            int index = i-L+1;
//            if ( index <= 0 ) index = 1;
//
//            bw.write(getMinValue(1,N,1,index,i)+" ");
//        }
//        bw.flush();
//        bw.close();
//    }
//
//    public static int merge(int left, int right){
//        return Math.min(left,right);
//    }
//
//    public static int initTree(int left, int right, int node){
//        if ( left == right ){
//            return tree[node] = arr[left];
//        }
//        int mid = left + (right-left)/2;
//        int leftMinVal = initTree(left,mid,node*2);
//        int rightMinVal = initTree(mid+1,right,node*2+1);
//        return tree[node] = merge(leftMinVal,rightMinVal);
//    }
//
//    public static int getMinValue(int left, int right, int node, int rangeLeft, int rangeRight){
//        if ( right < rangeLeft || rangeRight < left ){
//            return Integer.MAX_VALUE;
//        }
//        else if ( rangeLeft <= left && right <= rangeRight ){
//            return tree[node];
//        }
//
//        int mid = left + (right-left)/2;
//        int leftMinValue = getMinValue(left,mid,node*2,rangeLeft,rangeRight);
//        int rightMinValue = getMinValue(mid+1,right,node*2+1,rangeLeft,rangeRight);
//        return merge(leftMinValue,rightMinValue);
//    }
//
//    public static void printMap(){
//        for ( int x : tree ){
//            System.out.print(x+" ");
//        }
//        System.out.println();
//    }
//}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11003 {

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();

        int indexPointer = 0;
        st = new StringTokenizer(br.readLine());
        for ( int i = 0 ; i < N ; ++i ){
            int val = Integer.parseInt(st.nextToken());
            Node node = new Node(i,val);

            if ( !deque.isEmpty() ){
                if ( i - L == deque.getFirst().index ){
                    deque.pollFirst();

                    int size = deque.size();
                    for ( int j = 0 ; j < size ; ++j ){
                        if ( deque.getLast().value > val ){
                            deque.pollLast();
                        }
                        else {
                            break;
                        }
                    }
                }
                else{
                    int size = deque.size();
                    for ( int j = 0 ; j < size ; ++j ){
                        if ( deque.getLast().value > val ){
                            deque.pollLast();
                        }
                        else {
                            break;
                        }
                    }
                }
            }

            deque.offer(node);
            bw.write(deque.getFirst().value+" ");
//            printDequq(deque);
        }
        bw.flush();
        bw.close();
    }

    public static void printDequq(Deque<Node> deque){
        System.out.println("=======================");
        for ( Node node : deque ){
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

}