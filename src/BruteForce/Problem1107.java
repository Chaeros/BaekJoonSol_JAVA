// https://www.acmicpc.net/problem/1107
// 리모컨, Gold5
// 2023년 8월 14일
// 통과

package BruteForce;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1107 {
    static int N,M;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int result[];
    static int minVal=Integer.MAX_VALUE;
    static int lastDepth=0;
    static int answer=Integer.MAX_VALUE;
    static void dfs(int depth){

        if(arr.isEmpty())
        {
            answer=Math.abs(N-100);
            return;
        }

        if((depth!=0 && depth==lastDepth-1) || depth==lastDepth || depth==lastDepth+1){
            int val=0;
            for(int i=0;i<depth;++i){
                val*=10;
                val+=result[i];
            }

            if(minVal>=Math.abs(N-val)){

                minVal=Math.abs(N-val);

                int inputNumberOfDigits=0;
                if(val==0) inputNumberOfDigits=1;
                else inputNumberOfDigits=(int)Math.log10(val)+1;

                answer = Math.min(answer,minVal+inputNumberOfDigits);
                if(Math.abs(N-100)<answer){
                    answer=Math.abs(N-100);
                }
            }

            if(depth==lastDepth+1) return;
        }

        for(int x:arr){
            result[depth]=x;
            dfs(depth+1);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int numberOfDigits=N;
        if(numberOfDigits==0) ++lastDepth;
        while(numberOfDigits!=0){
            numberOfDigits/=10;
            ++lastDepth;
        }

        for(int i=0;i<10;++i){
            arr.add(i);
        }

        result = new int[lastDepth+1];
        int removeArrIndex[] = new int[M];
        if(M!=0) {
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<M;++i){
                removeArrIndex[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(removeArrIndex);

            for(int i=0;i<M;++i){
                arr.remove(removeArrIndex[i]-i);
            }
        }

        dfs(0);
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
