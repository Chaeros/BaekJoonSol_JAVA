import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;++i){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int tempN=N;
            int tempM=M;
            int count=0;
            while(tempN!=tempM){
                if(tempN>0) tempN--;
                else tempN=N;

                if(tempM<M) tempM++;
                else tempM=1;

                //System.out.println("tempN="+tempN+" "+"tempM="+tempM);
                ++count;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
}