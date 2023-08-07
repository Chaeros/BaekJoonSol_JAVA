// https://www.acmicpc.net/problem/2164
// 카드2, Silver5
// 2023년 8월 7일
// 통과

package DataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2164{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;++i){
            q.offer(i);
        }

        int i=1;
        while(true){
            if(q.size()==1){
                bw.write(q.peek()+"\n");
                break;
            }

            if(i%2==1){
                q.poll();
            }
            else{
                int x=q.poll();
                q.offer(x);
            }
            ++i;
        }
        bw.flush();
        bw.close();
    }
}