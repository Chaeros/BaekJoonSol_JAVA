// https://www.acmicpc.net/problem/2675
// 문자열 반복, Bronze2
// 2023년 8월 3일
// 통과

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2675 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;++i){
            st=new StringTokenizer(br.readLine());
            int R=Integer.parseInt(st.nextToken());
            String S=st.nextToken();

            for(int j=0;j<S.length();++j){
                for(int k=0;k<R;++k){
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }

    }
}
