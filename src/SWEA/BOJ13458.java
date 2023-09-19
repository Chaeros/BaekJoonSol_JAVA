// https://www.acmicpc.net/problem/13458
// 시험 감독, Bronze2
// 2023년 9월 19일
// 통과

package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int room[] = new int[N];
        for(int i=0;i<N;++i){
            room[i]=Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long directorCnt=N;
        for(int i=0;i<N;++i){
            room[i]-=B;

            if(room[i]>0){
                if(room[i]%C!=0) directorCnt+=(room[i]/C)+1;
                else if(room[i]%C==0) directorCnt+=room[i]/C;
            }
        }
        bw.write(directorCnt+"\n");
        bw.flush();
        bw.close();
    }
}
