// https://www.acmicpc.net/problem/1120
// 문자열, Silver4
// 2023년 7월 31일
// 통과

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1120 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1=st.nextToken();
        String str2=st.nextToken();

        int minDiff=(int)1e9;
        for(int i=0;i<str2.length()-str1.length()+1;++i){
            int diff=0;
            for(int j=0;j<str1.length();++j){
                if(str1.charAt(j)!=str2.charAt(j+i)){
                    ++diff;
                }
            }
            if(minDiff>diff){
                minDiff=diff;
            }
        }
        System.out.println(minDiff);

    }
}
