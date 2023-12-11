// https://www.acmicpc.net/problem/1476
// 날짜 계산, Silver5
// 2023년 12월 12일
// 통과

package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[3];
        for(int i=0;i<3;++i){
            arr[i]=1;
        }
        int count=1;

        while(true){
            if(arr[0]==E && arr[1]==S && arr[2]==M){
                break;
            }
            for(int i=0;i<3;++i){
                arr[i]++;
            }

            if(arr[0]==16) arr[0]=1;
            if(arr[1]==29) arr[1]=1;
            if(arr[2]==20) arr[2]=1;

            count++;
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
