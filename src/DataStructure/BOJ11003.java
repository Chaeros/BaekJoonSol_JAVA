// https://www.acmicpc.net/problem/11003
// 최솟값 찾기, Platinum5
// 2024년 1월 28일
// 통과

package DataStructure;

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