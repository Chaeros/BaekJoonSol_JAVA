import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int map[][];
    static boolean visited[][];

    static class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int resultSize=0;

    static ArrayList<Integer> resultList = new ArrayList<>();

    static void bfs(int x,int y){
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x,y));
        visited[x][y]=true;
        int size=1;

        while(!q.isEmpty()){
            Position now = q.poll();

            for(int i=0;i<4;++i){
                int mx = now.x+dx[i];
                int my = now.y+dy[i];

                if(mx>=N || mx<0 || my>=N || my<0) continue;
                if(visited[mx][my]) continue;
                if(map[now.x][now.y]!=map[mx][my]) continue;
                visited[mx][my]=true;
                q.offer(new Position(mx,my));
                ++size;
            }
        }

        if(map[x][y]==1){
            resultList.add(size);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;++i){
            String str = br.readLine();
            for(int j=0;j<N;++j){
                map[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                if(!visited[i][j]){
                    bfs(i,j);
                    if(map[i][j]==1) resultSize++;
                }
            }
        }
        Collections.sort(resultList);

        bw.write(resultSize+"\n");
        String result="";
        for(int x:resultList){
            result+=String.valueOf(x);
            result+=" ";
        }
        if(result.length()>0){
            result = result.substring(0,result.length()-1);
            bw.write(result);
        }
        bw.flush();
        bw.close();
    }
}