import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            for(int j=0;j<=i;++j){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=N-1;i>0;--i){
            for(int j=i;j>0;--j){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
