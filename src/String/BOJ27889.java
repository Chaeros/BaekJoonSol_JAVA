package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ27889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        if(str.equals("NLCS")){
            bw.write("North London Collegiate School");
        }
        else if(str.equals("BHA")){
            bw.write("Branksome Hall Asia");
        }
        else if(str.equals("KIS")){
            bw.write("Korea International School");
        }
        else if(str.equals("SJA")){
            bw.write("St. Johnsbury Academy");
        }
        bw.flush();
        bw.close();
    }

}
