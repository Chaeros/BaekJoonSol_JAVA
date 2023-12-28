package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution2072
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++)
        {
            int sum=0;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<10;++i){
                int val = Integer.parseInt(st.nextToken());
                if(val%2==1) sum+=val;
            }
            bw.write("#"+(test_case+1)+" "+sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}