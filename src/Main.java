import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            for(int j=N-i-1;j>0;--j){
                System.out.print(" ");
            }
            for(int k=1;k<=i+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}