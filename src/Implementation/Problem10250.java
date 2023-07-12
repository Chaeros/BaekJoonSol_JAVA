// https://www.acmicpc.net/problem/10250
// 10250번 ACM 호텔 Bronze3
// 2023년 7월 12일

package Implementation;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;

public class Problem10250 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T=Integer.parseInt(st.nextToken());
        for(int i=0;i<T;++i){
            st=new StringTokenizer(br.readLine());
            int H=Integer.parseInt(st.nextToken());
            int W=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());

            int floor=1;
            int index=1;
            for(int j=1;j<N;j++){
                ++floor;
                if(floor>H) {
                    floor = 1;
                    ++index;
                }
            }

            int result=floor*100+index;

            bw.write(valueOf(result)+"\n");
            bw.flush();
        }
        bw.close();
    }
}
