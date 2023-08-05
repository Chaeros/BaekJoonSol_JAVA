// https://www.acmicpc.net/problem/10818
// 최소, 최대
// 2023년 8월 3일
// 통과

package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10818 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int arr[]=new int[N];
        int maxVal=-(int)1e9;
        int minVal=(int)1e9;
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
            if(maxVal<arr[i]) maxVal=arr[i];
            if(minVal>arr[i]) minVal=arr[i];
        }
        System.out.println(minVal+" "+maxVal);
    }
}
