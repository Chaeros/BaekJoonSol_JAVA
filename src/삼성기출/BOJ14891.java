// https://www.acmicpc.net/problem/14891
// 톱니바퀴, Gold5
// 2023년 9월 27일
// 통과

package 삼성기출;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14891 {
    static ArrayList<LinkedList<Integer>> list = new ArrayList<>();

    static boolean visited[];
    static void rotate(int gear,int direction){

        if(gear<1 || gear>4 || visited[gear-1]) return;
        visited[gear-1]=true;

        if(gear-1>=1){
            if(list.get(gear-1).get(6)!=list.get(gear-2).get(2)){
                rotate(gear-1,direction*(-1));
            }
        }
        if(gear+1<=4){
            if(list.get(gear-1).get(2)!=list.get(gear).get(6)){
                rotate(gear+1,direction*(-1));
            }
        }

        if(direction==1){ // 시계방향
            int temp = list.get(gear-1).get(7);
            list.get(gear-1).remove(7);
            list.get(gear-1).add(0,temp);
        }
        else{ // 반시계방향
            int temp = list.get(gear-1).get(0);
            list.get(gear-1).remove(0);
            list.get(gear-1).add(temp);
        }
    }

    static int resultCalculate(){
        int resultSumt=0;

        for(int i=0;i<4;++i){
            if(list.get(i).get(0)==1){
                resultSumt+=(int)Math.pow(2,i);
            }
        }
        return resultSumt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0;i<4;++i){
            String str = br.readLine();
            list.add(new LinkedList<>());
            for(int j=0;j<8;++j){
                list.get(i).add(Integer.parseInt(String.valueOf(str.charAt(j))));
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;++i){
            st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
           visited=new boolean[4];


            rotate(gear,direction);
        }

        bw.write(resultCalculate()+"\n");
        bw.flush();
        bw.close();
    }
}
