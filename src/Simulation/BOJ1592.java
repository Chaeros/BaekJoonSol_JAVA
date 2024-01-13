// https://www.acmicpc.net/problem/1592
// 영식이와 친구들, Bronze2
// 2023년 1월 13일
// 통과

package Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1592 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int memberCount[] = new int[N+1];

        memberCount[1] = 1;
        int ballOwner = 1;
        int throwCount = 0;

        while( !isEnd(memberCount,M) ){
            if( memberCount[ballOwner] %2 == 0 ){
                ballOwner = throwClockwise(memberCount,ballOwner,M,L);
            }
            else if( memberCount[ballOwner] %2 == 1){
                ballOwner = throwCounterclockwise(memberCount,ballOwner,M,L);
            }
            throwCount++;
        }

        bw.write(throwCount + "\n");
        bw.flush();
        bw.close();
    }

    static boolean isEnd(int[] memberCount, int endPoint){
        boolean isEnd = false;
        for ( int i = 1 ; i < memberCount.length ; ++i ){
            if ( memberCount[i] == endPoint ){
                isEnd = true;
                break;
            }
        }
        return isEnd;
    }

    static int throwClockwise(int[] memberCount, int ballOwner, int endPoint ,int distance){
        int count = 0;
        while( count < distance ){
            ballOwner += 1;
            if ( ballOwner == memberCount.length ) ballOwner = 1;
            if ( memberCount[ballOwner] != endPoint ){
                count++;
            }
        }
        memberCount[ballOwner]++;
        return ballOwner;
    }

    static int throwCounterclockwise(int[] memberCount, int ballOwner, int endPoint, int distance){
        int count = 0;
        while( count < distance ){
            ballOwner -= 1;
            if ( ballOwner == 0 ) ballOwner = memberCount.length - 1;
            if ( memberCount[ballOwner] != endPoint ){
                count++;
            }
        }
        memberCount[ballOwner]++;
        return ballOwner;
    }
}
