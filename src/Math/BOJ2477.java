// https://www.acmicpc.net/problem/2477
// 참외밭, Silver2
// 2024년 1월 14일
// 통과

package Math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int melonUnit = Integer.parseInt(br.readLine());
        int directions[] = new int[12];
        int distances[] = new int[12];

        for ( int i = 0 ; i < 6 ; ++i ) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            directions[i] = direction;
            distances[i] = distance;

            directions[i+6] = direction;
            distances[i+6] = distance;
        }

        int bigArea = 0;
        int smallArea = 0;

        for ( int i = 3 ; i < 12 ; ++i ) {
            if( directions[i-1] == directions[i-3]
            && directions[i-2] == directions[i] ) {
                bigArea = ( distances[i] + distances[i-2] )
                        * ( distances[i-1] + distances[i-3] );
                smallArea = distances[i-1] * distances[i-2];
                bw.write((bigArea-smallArea) * melonUnit + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
