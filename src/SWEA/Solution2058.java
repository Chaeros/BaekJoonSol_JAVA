package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution2058
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int sum=0;
        for(int i=0;i<N.length();++i)
        {
            sum+=Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
