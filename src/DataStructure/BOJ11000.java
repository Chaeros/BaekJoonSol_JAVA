// https://www.acmicpc.net/problem/11000
// 강의실 배정, Gold5
// 2023년 9월 16일
// 통과

package DataStructure;

import java.io.*;
import java.util.*;

public class BOJ11000{
    static class Node implements Comparable<Node>{
        int val;
        int sign;

        public Node(int val, int sign) {
            this.val = val;
            this.sign = sign;
        }

        @Override
        public int compareTo(Node o) {
            if(this.val<o.val) return -1;
            else if(this.val>o.val) return 1;
            return 0;
        }
    }
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a,1));
            list.add(new Node(b,-1));
        }
        Collections.sort(list);

        int count=0;
        int maxCount=0;
        int i=0;
        while(i<N*2){
            if(maxCount==N) break;

            Node node = list.get(i);
            while(node.val==list.get(i).val){
                if(list.get(i).sign==1){
                    ++count;
                }
                else{
                    --count;
                }
                if(++i==2*N) break;
            }
            maxCount=Math.max(maxCount,count);
        }
        bw.write(maxCount+"\n");
        bw.flush();
        bw.close();
    }
}