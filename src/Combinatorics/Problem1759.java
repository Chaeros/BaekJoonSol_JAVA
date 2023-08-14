// https://www.acmicpc.net/problem/1759
// 암호 만들기, Gold5
// 2023년 8월 14일
// 통과

package Combinatorics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1759 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L,C;
    static char arr[];
    static char result[];

    static void dfs(int depth,int beginIndex) throws IOException {
        if(depth==L){
            int vowelCount=0;
            for(int i=0;i<L;++i){
                if(result[i]=='a' || result[i]=='e' || result[i]=='i' ||
                   result[i]=='o' || result[i]=='u'){
                    ++vowelCount;
                }
            }
            if(vowelCount<=L-2 && vowelCount>0){
                bw.write(new String(result)+"\n");
            }
        }
        else{
            for(int i=beginIndex;i<C;++i){
                result[depth]=arr[i];
                dfs(depth+1,i+1);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr= new char[C];
        result = new char[L];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;++i){
            arr[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0,0);

        bw.flush();
        bw.close();
    }
}
