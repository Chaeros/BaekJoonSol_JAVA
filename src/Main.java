import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val[] = new int[3];
            val[0] = Integer.parseInt(st.nextToken());
            val[1] = Integer.parseInt(st.nextToken());
            val[2] = Integer.parseInt(st.nextToken());

            if(val[0]==0 && val[1]==0 && val[2]==0){
                bw.close();
                break;
            }

            Arrays.sort(val);

            if((long)Math.pow(val[0],2)+(long)Math.pow(val[1],2)==(long)Math.pow(val[2],2)) bw.write("right\n");
            else bw.write("wrong\n");
            bw.flush();
        }
        bw.close();
    }
}