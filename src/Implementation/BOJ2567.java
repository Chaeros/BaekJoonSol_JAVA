package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2567 {

    public static int N;
    public static boolean map[][] = new boolean[100][100];
    public static boolean visited[][] = new boolean[100][100];

    public static int dx[] = { -1, 1, 0, 0 };
    public static int dy[] = { 0, 0, -1, 1 };

    public static int perimeter = 0;

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {x,y});
        visited[x][y]=true;

        while(!q.isEmpty()) {
            int now[] = q.poll();

            for ( int i = 0 ; i < 4 ; ++i ) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if ( mx < 0 || mx >= 100 || my < 0 || my >=100 ) {
                    perimeter++;
                    continue;
                }
                if ( visited[mx][my] ) continue;
                if ( !map[mx][my] ) {
                    perimeter++;
                }
                else {
                    q.offer(new int[] {mx,my});
                    visited[mx][my] = true;
                }
            }

        }
    }

    public static void printMap() {
        for ( int r = 0 ; r < 100 ; r++ ) {
            for ( int c = 0 ; c < 100 ; c++ ) {
                if( map[r][c] ) System.out.print("1 ");
                else System.out.print("0 ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());


        for ( int i = 0 ; i < N ; ++i ) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for ( int r = 90 - x ; r < 100 - x ; ++r ) {
                for ( int c = y ; c < y + 10 ; ++c ) {
                    if ( r >= 0 || r < 100 || c >= 0 || c < 100 ) {
                        map[r][c] = true;
                    }
                }
            }
        }
//		printMap();

        for ( int r = 0 ; r < 100 ; r++ ) {
            for ( int c = 0 ; c < 100 ; c++ ) {
                if ( map[r][c] && !visited[r][c] ) bfs(r,c);
            }
        }

        bw.write(perimeter+"\n");
        bw.flush();
        bw.close();

    }
}
