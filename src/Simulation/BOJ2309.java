// https://www.acmicpc.net/problem/2309
// 일곱 난쟁이, Bronze1
// 2024년 1월 13일
// 통과

package Simulation;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {

    public final static int dwarfNumber = 9;
    public static int heights[];
    public static int drarfGroup[] = new int[7];
    public static int heightSum = 0;

    public static boolean isEnd = false;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        heights = new int[dwarfNumber];
        for( int i = 0 ; i < 9 ; ++i ){
            heights[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0);
        bw.flush();
        bw.close();
    }

    static void dfs(int index, int depth) throws IOException{
        if ( isEnd ) return;
        if ( depth == 7 ){
            if( heightSum == 100 ){
                int tempHeights[] = drarfGroup.clone();
                Arrays.sort(tempHeights);
                printSevenDrarfHeights(tempHeights);
                isEnd = true;
            }
            return;
        }

        for( int i = index ; i < 9 ; ++i ){
            heightSum += heights[i];
            drarfGroup[depth] = heights[i];
            dfs(i+1,depth+1);
            heightSum -= heights[i];
        }
    }

    static void printSevenDrarfHeights(int[] heights) throws IOException{
        for(int height : heights ){
            bw.write(height + "\n");
        }
    }
}
