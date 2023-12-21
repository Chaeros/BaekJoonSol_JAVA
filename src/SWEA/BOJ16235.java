package SWEA;

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
            else{
                return 1;
            }
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
            for(int w=0;w<woodList.size();){
                int x=woodList.get(w).x;
                int y=woodList.get(w).y;
                int age=woodList.get(w).age;
                if(groundNourishment[x][y]>=age){
                    groundNourishment[x][y]-=age;
                    woodList.get(w).age++;
                    ++w;
                }
                else{
                    removeWoodList.add(new Wood(x,y,age));
                    woodList.remove(w);
                }
            }

            //Summer
            for(Wood wood:removeWoodList){
                groundNourishment[wood.x][wood.y]+=wood.age/2;
            }

            //Fall
            ArrayList<Wood> tempWoodList = new ArrayList<>(woodList);
            for(Wood wood:tempWoodList){
                if(wood.age%5==0){
                    for(int a=0;a<8;++a){
                        int mx = wood.x+dx[a];
                        int my = wood.y+dy[a];

                        if(mx<0 || mx>=N || my<0 || my>=N) continue;
                        woodList.add(0,new Wood(mx,my,1));
                    }
                }
            }

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
