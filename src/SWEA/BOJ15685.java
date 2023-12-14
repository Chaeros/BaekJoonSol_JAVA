package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {

    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static class Position{
        int x;
        int y;

        public Position(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static ArrayList<Position> list;
    public static void rotate(){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0;i<=100;++i){
            map.add(new ArrayList<>());
            for(int j=0;j<=100;++j){
                map.get(i).add(0);
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int endX = x, endY=y;

            if(d==0){
                endX=x+1;
            }
            else if(d==1){
                endY=y+1;
            }
            else if(d==2){
                endX=x-1;
            }
            else if(d==3){
                endY=y-1;
            }
            list.add(new Position(x,y));
            list.add(new Position(endX,endY));
        }
    }
}
