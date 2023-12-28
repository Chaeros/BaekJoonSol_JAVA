package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution2063
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int val[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            val[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(val);
        bw.write(val[(N-1)/2]+"\n");
        bw.flush();
        bw.close();
    }
}