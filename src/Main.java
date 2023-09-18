import java.io.*;
import java.util.*;

public class Main{
    static int fun(int a){
        a=2;
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int a =1;
        bw.write(a+"\n");

        a=fun(a);
        bw.write(a+"\n");

        bw.flush();
        bw.close();
    }
}