package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ19236 {

    static ArrayList<ArrayList<ArrayList<Fish>>> map = new ArrayList<>();

    static class Fish{
        int number;
        int direction;

        public Fish(int number,int direction){
            this.number=number;
            this.direction=direction;
        }
    }

    static int sharkPosition[] = new int[2];
    static int sharkDirection=0;
    static int eatingSum=0;

    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,-1,-1,-1,0,1,1,1};

    static void dfs(int index){



    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0;i<4;++i){
            map.add(new ArrayList<>());
            for(int j=0;j<4;++j){
                map.get(i).add(new ArrayList<>());
            }
        }
        sharkPosition[0]=0;
        sharkPosition[1]=0;

        for(int i=0;i<4;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;++j){
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                map.get(i).get(j).add(new Fish(number,direction));
            }
        }

        while(true){

        }
    }
}
