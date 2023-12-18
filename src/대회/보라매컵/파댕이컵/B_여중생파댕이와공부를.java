package 대회.보라매컵.파댕이컵;

import java.io.*;
import java.util.StringTokenizer;

public class B_여중생파댕이와공부를 {

    public static int N,M;
    public static String str[] = new String[71*3];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void success(int x,int y,boolean isOne){
        if(isOne){
            str[3*x] = str[3*x].substring(0,8*y+1)+"*****"+str[3*x].substring(8*y+6);
            str[3*x+1] = str[3*x+1].substring(0,8*y)+String.valueOf("*")+str[3*x+1].substring(8*y+1,8*y+1+5)+String.valueOf("*")+str[3*x+1].substring(8*y+1+5+1);
            str[3*x+2] = str[3*x+2].substring(0,8*y+1)+"*****"+str[3*x+2].substring(8*y+6);
        }
        else{
            str[3*x] = str[3*x].substring(0,8*y+1)+"******"+str[3*x].substring(8*y+7);
            str[3*x+1] = str[3*x+1].substring(0,8*y)+String.valueOf("*")+str[3*x+1].substring(8*y+1,8*y+1+6)+String.valueOf("*")+str[3*x+1].substring(8*y+1+6+1);
            str[3*x+2] = str[3*x+2].substring(0,8*y+1)+"******"+str[3*x+2].substring(8*y+7);
        }
    }

    public static void fail(int x,int y){
        str[3*x] = str[3*x].substring(0,8*y+3)+String.valueOf("/")+str[3*x].substring(8*y+4,8*M);
        str[3*x+1] = str[3*x+1].substring(0,8*y+2)+String.valueOf("/")+str[3*x+1].substring(8*y+3,8*M);
        str[3*x+2] = str[3*x+2].substring(0,8*y+1)+String.valueOf("/")+str[3*x+2].substring(8*y+2,8*M);
    }

    public static void print() throws IOException {
        for(int i=0;i<3*N;++i){
            bw.write(str[i]+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<3*N;++i){
            str[i]=br.readLine();
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                int a = Integer.parseInt(String.valueOf(str[i*3+1].charAt(j*8+1)));
                int b = Integer.parseInt(String.valueOf(str[i*3+1].charAt(j*8+3)));
                if(a+b<10){
                    if(a+b==Integer.parseInt(String.valueOf(str[i*3+1].charAt(j*8+5)))){
                        success(i,j,true);
                    }
                    else{
                        fail(i,j);
                    }
                }
                else{
                    if(a+b==Integer.parseInt(str[i*3+1].substring(j*8+5,j*8+7))){
                        success(i,j,false);
                    }
                    else{
                        fail(i,j);
                    }
                }
            }
        }

        print();
        bw.flush();
        bw.close();
    }
}
