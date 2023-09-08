import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger zero = new BigInteger("0");

        for(int i=0;i<3;++i){
            int N = Integer.parseInt(br.readLine());
            BigInteger sum=new BigInteger("0");
            for(int j=0;j<N;++j){
                sum=sum.add(new BigInteger(br.readLine()));
            }
            if(sum.compareTo(zero)==0) bw.write(0+"\n");
            else if(sum.compareTo(zero)<0) bw.write("-\n");
            else bw.write("+\n");
        }
        bw.flush();
        bw.close();
    }
}