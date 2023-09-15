// https://www.acmicpc.net/problem/10828
// 스택, Silver4
// 2023년 9월 13일
// 통과

package Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> q = new Stack<>();
        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                q.push(x);
            }
            else if(command.equals("top")){
                if(q.isEmpty()) bw.write("-1\n");
                else bw.write(q.peek()+"\n");
            }
            else if(command.equals("size")){
                bw.write(q.size()+"\n");
            }
            else if(command.equals("empty")){
                if(q.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command.equals("pop")){
                if(q.isEmpty()) bw.write("-1\n");
                else bw.write(q.pop()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
