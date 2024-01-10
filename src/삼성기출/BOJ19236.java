package 삼성기출;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ19236 {

    public static class Fish{
        int x;
        int y;
        int direction;
        public Fish(int x,int y,int direction){
            this.x=x;
            this.y=y;
            this.direction=direction;
        }
    }

    public static int result;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int map[][] = new int[4][4];
        HashMap<Integer,Fish> hash = new HashMap<>();

        for(int i=0;i<4;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;++j){
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                map[i][j]=number;
                hash.put(number,new Fish(i,j,direction-1));
            }
        }

        int sx=0;
        int sy=0;
        Fish first = hash.get(map[0][0]);
        result=map[0][0];
        int sd=first.direction;
        int number=map[0][0];
        map[0][0]=0;
        hash.remove(number);

        dfs(map,hash,number,new Fish(sx,sy,sd));
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int[][] map, HashMap<Integer,Fish> hash,int sum, Fish shark){
        result=Math.max(result,sum);

        int[][] map_copy = new int[4][4];
        for(int i=0;i<4;++i){
            map_copy[i]=map[i].clone();
        }
        HashMap<Integer,Fish> hash_copy = (HashMap<Integer, Fish>) hash.clone();

        for(int i=1;i<=16;++i){
            if(!hash.containsKey(i)) continue;
            Fish fish = hash_copy.get(i);
            if(map[fish.x][fish.y]==0) continue;

            int direction = fish.direction;
            int turn_cnt=0;
            boolean isPossibleMove=false;
            int mx=fish.x;
            int my=fish.y;

            while(turn_cnt++ < 8) {
                mx = fish.x + dx[direction];
                my = fish.y + dy[direction];
                if(mx < 0 || mx >= 4 || my < 0 || my >= 4 || (mx == shark.x && my == shark.y)) {
                    direction = (direction+1) % 8;
                } else {
                    isPossibleMove = true;
                    break;
                }
            }

            if(isPossibleMove){
                if(map_copy[mx][my]!=0){
                    map_copy[fish.x][fish.y]=map_copy[mx][my];
                    Fish objectFish = hash_copy.get(map_copy[mx][my]);
                    hash_copy.put(map_copy[mx][my],new Fish(fish.x,fish.y,objectFish.direction));
                    map_copy[mx][my]=i;
                    hash_copy.put(i,new Fish(mx,my,direction));
                }
                else{
                    map_copy[mx][my]=i;
                    hash_copy.put(i,new Fish(mx,my,direction));
                    map_copy[fish.x][fish.y]=0;
                }
            }
        }

        for(int i=1;i<=4;++i){
            int mx = shark.x+dx[shark.direction]*i;
            int my = shark.y+dy[shark.direction]*i;

            if(mx<0 || mx>=4 || my<0 || my>= 4) break;

            if(map_copy[mx][my] != 0){
                int number = map_copy[mx][my];
                map_copy[mx][my]=0;
                int direction = hash_copy.get(number).direction;
                hash_copy.remove(number);
                dfs(map_copy,hash_copy,sum+number,new Fish(mx,my,direction));
                hash_copy.put(number,new Fish(mx,my,direction));
                map_copy[mx][my]=number;
            }
        }
    }

}
