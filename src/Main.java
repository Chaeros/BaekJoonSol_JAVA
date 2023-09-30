import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum=0;
        for(int i=0;i<4;++i){
            sum+=Integer.parseInt(br.readLine());
        }

        int minute=sum/60;
        int seconds=sum%60;

        bw.write(minute+"\n"+seconds+"\n");
        bw.flush();
        bw.close();
    }
}
