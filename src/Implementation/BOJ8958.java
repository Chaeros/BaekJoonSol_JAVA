package Implementation;

import java.io.*;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for ( int i = 0 ; i < N ; ++i ){
            String str = br.readLine();
            int cnt = 1;
            int sum = 0;
            for ( int j = 0 ; j < str.length() ; ++j ){
                if ( str.charAt(j) == 'O' ){
                    sum += cnt++;
                }
                else if ( str.charAt(j) == 'X' ){
                    cnt = 1;
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
