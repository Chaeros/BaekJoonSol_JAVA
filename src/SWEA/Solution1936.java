package SWEA;

import java.io.*;
import java.util.StringTokenizer;

class Solution1936
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char winner = 'A';

        if(a==1 && b==2){
            winner = 'B';
        }
        else if(a==1 && b==3){
            winner = 'A';
        }
        else if(a==2 && b==1){
            winner = 'A';
        }
        else if(a==2 && b==3){
            winner = 'B';
        }
        else if(a==3 && b==1){
            winner = 'B';
        }
        else if(a==3 && b==2){
            winner = 'A';
        }

        bw.write(winner+"\n");
        bw.flush();
        bw.close();
    }
}