// https://www.acmicpc.net/problem/17404
// RGB거리 2, Gold4
// 2023년 8월 30일
// 통과

package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17404{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int rd[][]=new int [N][3];
        int gd[][]=new int [N][3];
        int bd[][]=new int [N][3];

        st=new StringTokenizer(br.readLine());
        int red = Integer.parseInt(st.nextToken());
        int green = Integer.parseInt(st.nextToken());
        int blue = Integer.parseInt(st.nextToken());

        rd[0][0]=red;
        rd[0][1]=red;
        rd[0][2]=red;

        gd[0][0]=green;
        gd[0][1]=green;
        gd[0][2]=green;

        bd[0][0]=blue;
        bd[0][1]=blue;
        bd[0][2]=blue;

        for(int i=1;i<N-1;++i){
            st=new StringTokenizer(br.readLine());
            red = Integer.parseInt(st.nextToken());
            green = Integer.parseInt(st.nextToken());
            blue = Integer.parseInt(st.nextToken());

            if(i==1) rd[i][0]=1000001;
            else rd[i][0]=Math.min(rd[i-1][1]+red,rd[i-1][2]+red);
            rd[i][1]=Math.min(rd[i-1][0]+green,rd[i-1][2]+green);
            rd[i][2]=Math.min(rd[i-1][0]+blue,rd[i-1][1]+blue);

            gd[i][0]=Math.min(gd[i-1][1]+red,gd[i-1][2]+red);
            if(i==1) gd[i][1]=1000001;
            else gd[i][1]=Math.min(gd[i-1][0]+green,gd[i-1][2]+green);
            gd[i][2]=Math.min(gd[i-1][0]+blue,gd[i-1][1]+blue);

            bd[i][0]=Math.min(bd[i-1][1]+red,bd[i-1][2]+red);
            bd[i][1]=Math.min(bd[i-1][0]+green,bd[i-1][2]+green);
            if(i==1) bd[i][2]=1000001;
            else bd[i][2]=Math.min(bd[i-1][0]+blue,bd[i-1][1]+blue);
        }

        st=new StringTokenizer(br.readLine());
        red = Integer.parseInt(st.nextToken());
        green = Integer.parseInt(st.nextToken());
        blue = Integer.parseInt(st.nextToken());

        rd[N-1][1]=Math.min(rd[N-2][0]+green,rd[N-2][2]+green);
        rd[N-1][2]=Math.min(rd[N-2][0]+blue,rd[N-2][1]+blue);
        int rResult=Math.min(rd[N-1][1],rd[N-1][2]);

        gd[N-1][0]=Math.min(gd[N-2][1]+red,gd[N-2][2]+red);
        gd[N-1][2]=Math.min(gd[N-2][0]+blue,gd[N-2][1]+blue);
        int gResult=Math.min(gd[N-1][0],gd[N-1][2]);

        bd[N-1][0]=Math.min(bd[N-2][1]+red,bd[N-2][2]+red);
        bd[N-1][1]=Math.min(bd[N-2][0]+green,bd[N-2][2]+green);
        int bResult=Math.min(bd[N-1][0],bd[N-1][1]);

        int ans = Math.min(rResult,gResult);
        bw.write(Math.min(ans,bResult)+"\n");
        bw.flush();
        bw.close();
    }
}