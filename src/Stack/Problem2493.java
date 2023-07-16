// https://www.acmicpc.net/problem/2493
// 탑, Gold5
// 2023년 7월 16일

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem2493 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int result[] = new int[N];

        for(int i=0;i<N;++i){
            for(int j=i-1;j>=0;--j){
                if(list.get(i)<=list.get(j)){
                    result[i]=j+1;
                    break;
                }
            }
        }

        for(int i=0;i<N;++i){
            System.out.print(result[i]+" ");
        }
    }
}
