// https://www.acmicpc.net/problem/9252
// LCS 2, Gold4
// 2023년 8월 26일
// 통과

package LCS;

import java.io.*;

public class Problem9252 {
    static int c[][];
    static int b[][];
    static String str;
    static String str2;
    static String result="";
    static void getLCS(int x, int y){
        if(x!=0 && y!=0){
            if(b[x][y]==1){
                result=str.charAt(x-1)+result;
                getLCS(x-1,y-1);
            }
            else if(b[x][y]==2) getLCS(x-1,y);
            else getLCS(x,y-1);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        str2 = br.readLine();

        int strLen=str.length()+1;
        int str2Len=str2.length()+1;

        c = new int[strLen][str2Len];
        b = new int[strLen][str2Len];

        for(int i=1;i<strLen;++i){
            for(int j=1;j<str2Len;++j){
                if(str.charAt(i-1)==str2.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]=1;
                }
                else{
                    if(c[i-1][j]>c[i][j-1]){
                        c[i][j]=c[i-1][j];
                        b[i][j]=2;
                    }
                    else{
                        c[i][j]=c[i][j-1];
                        b[i][j]=3;
                    }
                }
            }
        }

//        for(int i=0;i<strLen;++i){
//            for(int j=0;j<str2Len;++j){
//                System.out.print(c[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i=0;i<strLen;++i){
//            for(int j=0;j<str2Len;++j){
//                System.out.print(b[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        getLCS(strLen-1,str2Len-1);

        bw.write(c[strLen-1][str2Len-1]+"\n");
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
