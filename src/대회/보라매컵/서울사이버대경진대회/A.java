package 대회.보라매컵.서울사이버대경진대회;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result[] = new int[3];
        int maxVal=0;
        for(int i=0;i<N;++i){
            if(str.charAt(i)=='B'){
                result[0]++;
                maxVal=Math.max(maxVal,result[0]);
            }
            else if(str.charAt(i)=='S'){
                result[1]++;
                maxVal=Math.max(maxVal,result[1]);
            }
            else if(str.charAt(i)=='A'){
                result[2]++;
                maxVal=Math.max(maxVal,result[2]);
            }
        }

        if(maxVal==result[0] && maxVal==result[1] && maxVal==result[2]){
            bw.write("SCU\n");
        }
        else {
            String answer = "";
            if(maxVal==result[0]){
                answer+='B';
            }
            if(maxVal==result[1]){
                answer+='S';
            }
            if(maxVal==result[2]){
                answer+='A';
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
