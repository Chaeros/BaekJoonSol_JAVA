// https://www.acmicpc.net/problem/1958
// LCS3, Gold4
// 2023년 11월 11일
// 통과

package LCS;

import java.io.*;

public class BOJ1958 {

    static int d[][][] = new int[101][101][101];
    static int maxVal=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        for(int i=0;i<str1.length();++i){
            for(int j=0;j<str2.length();++j){
                for(int k=0;k<str3.length();++k){
                    if(str1.charAt(i)==str2.charAt(j) &&
                        str2.charAt(j)==str3.charAt(k)){
                        d[i+1][j+1][k+1]=d[i][j][k]+1;
                    }
                    else{
                        int val = Math.max(d[i][j+1][k+1],d[i+1][j][k+1]);
                        val = Math.max(val,d[i+1][j+1][k]);
                        d[i+1][j+1][k+1]=val;
                    }
                    maxVal = Math.max(maxVal,d[i+1][j+1][k+1]);
                }

            }
        }

        bw.write(maxVal+"\n");
        bw.flush();
        bw.close();
    }
}
