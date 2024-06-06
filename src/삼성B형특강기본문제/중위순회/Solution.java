package 삼성B형특강기본문제.중위순회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

    public static int N;
    public static char tree[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for ( int t = 1 ; t <= 10 ; ++t ) {
            N = Integer.parseInt(br.readLine());
            tree = new char[N+1];
            for ( int i = 0 ; i < N ; ++i ) {
                st = new StringTokenizer(br.readLine());

                int nodeNumber = Integer.parseInt(st.nextToken());
                tree[nodeNumber] = st.nextToken().charAt(0);
                while(st.hasMoreTokens()) {
                    st.nextToken();
                }
            }

            sb.append("#"+t+" ");
            inorderSearch(1);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void inorderSearch(int node) {
        if ( node > N ) {
            return;
        }
        inorderSearch(node*2);
        sb.append(tree[node]);
        inorderSearch(node*2+1);
    }
}

