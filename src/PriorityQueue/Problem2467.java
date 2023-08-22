// https://www.acmicpc.net/problem/2467
// 용액, Gold5
// 2023년 8월 22일
// 통과

package PriorityQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2467 {

    static class Node implements Comparable<Node>{
        int sign;
        int number;

        public Node(int sign,int number){
            this.sign=sign;
            this.number=number;
        }
        @Override
        public int compareTo(Node o) {
            if(this.number<o.number) return -1;
            else return 1;
        }
    }

    static PriorityQueue<Node> q = new PriorityQueue<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            int num = Integer.parseInt(st.nextToken());
            int sign;

            if(num<0) sign=-1;
            else sign=1;

            Node node = new Node(sign, num*sign);
            q.offer(node);
        }

        int answer = (int)1e11;
        Node pre = q.poll();

        int first=0;
        int second=0;
        for(int i=1;i<N;++i){
            Node now = q.poll();
            int diff = Math.abs(now.number*now.sign+
                    pre.number*pre.sign);
            if(answer>diff){
                answer=diff;
                first=pre.number*pre.sign;
                second=now.number*now.sign;
                //System.out.println(first+" "+second);
            }
            answer = Math.min(answer,diff);
            pre=now;
        }

        if(first<second) bw.write(first+" "+second+"\n");
        else bw.write(second+" "+first+"\n");

        bw.flush();
        bw.close();
    }
}
