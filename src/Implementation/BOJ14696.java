package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for ( int t = 0 ; t < N ; ++t ) {
            int A[] = new int[5];
            int B[] = new int[5];

            for ( int i = 0 ; i < 2 ; ++i ) {
                st = new StringTokenizer(br.readLine());
                int gabage = Integer.parseInt(st.nextToken());
                while ( st.hasMoreElements() ) {
                    int shape = Integer.parseInt(st.nextToken());
                    if ( i == 0 ) A[shape]++;
                    else if ( i == 1 ) B[shape]++;
                }
            }

            for ( int i = 4; i > 0 ; --i ) {
                if ( A[i] == B[i] ) {
                    if ( i == 1 ) {
                        bw.write("D\n");
                    }
                    continue;
                }
                else if ( A[i] > B[i] ) {
                    bw.write("A\n");
                    break;
                }
                else if ( A[i] < B[i] ) {
                    bw.write("B\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
