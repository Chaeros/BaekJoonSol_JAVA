import java.io.*;
import java.lang.reflect.Array;
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

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        list.get(0).add(3);
        bw.write(list.get(0).get(0)+"\n");

        list.get(0).set(0,2);
        bw.write(list.get(0).get(0)+"\n");

        bw.flush();
        bw.close();
    }
}