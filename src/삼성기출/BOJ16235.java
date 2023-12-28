// https://www.acmicpc.net/problem/16235
// 나무 재테크, Gold3
// 2023년 12월 22일
// 통과

package 삼성기출;

import java.io.*;
import java.util.*;

public class BOJ16235 {
    static int N,M,K;
    static int A[][];
    static List<Wood> woodList = new LinkedList<>();
    static int groundNourishment[][];
    static int dx[]={-1,-1,-1,0,1,1,1,0};
    static int dy[]={-1,0,1,1,1,0,-1,-1};
    static class Wood implements Comparable<Wood>{
        int x;
        int y;
        int age;
        public Wood(int x,int y,int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }

        @Override
        public int compareTo(Wood o){
            if(this.age<o.age){
                return -1;
            }
            else if(this.age>o.age){
                return 1;
            }
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        groundNourishment = new int[N][N];

        for(int i=0;i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j){
                A[i][j] = Integer.parseInt(st.nextToken());
                groundNourishment[i][j]=5;
            }
        }

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            woodList.add(new Wood(x,y,age));
        }
        Collections.sort(woodList);

        for(int i=0;i<K;++i){
            //Spring
            ArrayList<Wood> removeWoodList = new ArrayList<>();
            Iterator<Wood> iterator = woodList.iterator();
            while(iterator.hasNext()){
                Wood wood= iterator.next();
                if(groundNourishment[wood.x][wood.y]>=wood.age){
                    groundNourishment[wood.x][wood.y]-=wood.age;
                    wood.age++;
                }
                else{
                    removeWoodList.add(wood);
                    iterator.remove();
                }
            }

            //Summer
            for(Wood wood:removeWoodList){
                groundNourishment[wood.x][wood.y]+=wood.age/2;
            }

            //Fall
            LinkedList<Wood> childWood = new LinkedList<>();
            for(Wood wood:woodList){
                if(wood.age%5==0){
                    for(int a=0;a<8;++a){
                        int mx = wood.x+dx[a];
                        int my = wood.y+dy[a];

                        if(mx<0 || mx>=N || my<0 || my>=N) continue;
                        childWood.add(new Wood(mx,my,1));
                    }
                }
            }
            woodList.addAll(0,childWood);

            //Winter
            for(int r=0;r<N;++r){
                for(int c=0;c<N;++c){
                    groundNourishment[r][c]+=A[r][c];
                }
            }
        }

        bw.write(woodList.size()+"\n");
        bw.flush();
        bw.close();
    }
}
