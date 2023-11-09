import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
                arr[i]=Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0;i<N;++i){
            if(arr[i]==M) ++result;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
