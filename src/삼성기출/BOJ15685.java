// https://www.acmicpc.net/problem/15685
// 드래곤 커브, Gold3
// 2023년 12월 15일
// 통과

package 삼성기출;

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
    public static int endX=0, endY=0;
    public static void rotate(){
        ArrayList<Position> tempList = new ArrayList<>(list);
        for(Position position:tempList){
            int dx = endX - position.x;
            int dy = endY - position.y;
            list.add(new Position(endX+dy,endY+dx*(-1)));
        }
//        System.out.println("0.x="+tempList.get(0).x+" 0.y="+tempList.get(0).y);

        int tempEndX = endX;
        int tempEndY = endY;

        endX = tempEndX + tempEndY - tempList.get(0).y;
        endY = tempEndY + (tempEndX - tempList.get(0).x)*-1;
//        System.out.println("endX="+endX+" endY="+endY);
    }

    public static void drawRealMap(){
        for(Position position:list){
//            System.out.println("x="+position.x+" y="+position.y);
            map.get(position.y).set(position.x, 1);
        }
    }

    public static int getResult(){
        int answer = 0;
        for(int i=0;i<100;++i){
            for(int j=0;j<100;++j){
                if(map.get(i).get(j)==1 && map.get(i).get(j+1)==1
                && map.get(i+1).get(j)==1 && map.get(i+1).get(j+1)==1){
                    answer++;
                }
            }
        }
        return answer;
    }

//    public static void printMap(){
//        for(int i=0;i<=100;++i){
//            for(int j=0;j<=100;++j){
//                System.out.print(map.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }
//    }

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

            endX = x;
            endY = y;

            if(d==0){ // 오른쪽
                endX=x+1;
            }
            else if(d==1){ // 위
                endY=y-1;
            }
            else if(d==2){ // 왼쪽
                endX=x-1;
            }
            else if(d==3){ // 아래
                endY=y+1;
            }
            list.add(new Position(x,y));
            list.add(new Position(endX,endY));

            for(int j=0;j<g;++j){
                rotate();
            }
            drawRealMap();
        }
        bw.write(getResult()+"\n");
        bw.flush();
        bw.close();
    }
}
