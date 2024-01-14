package Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int positions[] = new int[8];

        for ( int i = 0 ; i < 4 ; ++i ) {
            st = new StringTokenizer(br.readLine());
            for ( int j = 0 ; j < 8 ; ++j ){
                positions[i] = Integer.parseInt(st.nextToken());
            }

        }
    }

    public static boolean codeD( int[] positions ){
        if ( positions[0]  )
    }
}
