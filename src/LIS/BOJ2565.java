// https://www.acmicpc.net/problem/2565
// 전깃줄, Gold5
// 2023년 12월 1일
// 통과

package LIS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2565 {

    static class Node implements Comparable<Node>{

        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start<o.start) return -1;
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node node = new Node(a,b);
            list.add(node);
        }
        Collections.sort(list);

        result.add(list.get(0).end);
        for(int i=1;i<N;++i){
            int value = list.get(i).end;

            if(result.get(result.size()-1)<value){
                result.add(value);
            }
            else{
                for(int j=0;j<result.size();++j){
                    if(result.get(j)>value){
                        result.set(j,value);
                        break;
                    }
                }
            }
        }

        bw.write(N-result.size()+"\n");
        bw.flush();
        bw.close();
    }
}
