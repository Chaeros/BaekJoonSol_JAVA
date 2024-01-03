package SWEA;

import java.io.*;
import java.util.*;

class Solution1959
{
    static int N,M;
    static int arr1[],arr2[];
    static int maxSum=0;

    static void calculateSum(int index,int biggerArr){
        int sum=0;

        if(biggerArr==1){
            for(int i=0;i<M;++i){
                sum+=arr1[i+index]*arr2[i];
            }
        }
        else if(biggerArr==2){
            for(int i=0;i<N;++i){
                sum+=arr1[i]*arr2[i+index];
            }
        }
        maxSum = Math.max(maxSum,sum);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr1 = new int[N];
            arr2 = new int[M];

            maxSum=0;

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;++i){
                arr1[i]=Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;++i){
                arr2[i]=Integer.parseInt(st.nextToken());
            }

            if(N<=M){
                for(int i=0;i<=M-N;++i){
                    calculateSum(i,2);
                }
            }
            else{
                for(int i=0;i<=N-M;++i){
                    calculateSum(i,1);
                }
            }
            bw.write("#"+test_case+" "+maxSum+"\n");
        }
        bw.flush();
        bw.close();
    }
}