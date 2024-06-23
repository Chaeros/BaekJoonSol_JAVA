package 삼성B형.섬지키기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class UserSolution {

    int N;
    int map[][];
    List<Node>[] hashs;
    boolean isVisited[][];

    class Node{
        int x;
        int y;
        boolean isHeight;
        public Node(int x, int y, boolean isHeight) {
            this.x = x;
            this.y = y;
            this.isHeight = isHeight;
        }
        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", isHeight=" + isHeight + "]";
        }
    }

    void init(int N, int mMap[][]) {
        this.N=N;
        map = new int[23][23];
        hashs = new ArrayList[10001];
        for(int r=1;r<=N;++r) {
            for(int c=1;c<=N;++c) {
                map[r][c]=mMap[r-1][c-1];
            }
        }
        for(int i=0;i<=10000;++i) {
            hashs[i] = new ArrayList<>();
        }
        int[] array= new int[5];
        for(int r=1;r<=N;++r) {
            for(int c=1;c<=N;++c) {
                for(int l=2;l<=5;++l) {
                    if(N-c-l+1>=0) {
                        for(int i=0;i<l;++i) {
                            array[i]=map[r][c+i];
                        }
                        int hash=makeHash(l,array);
                        hashs[hash].add(new Node(r,c,false));
                    }
                    if(N-r-l+1>=0){
                        for(int i=0;i<l;++i) {
                            array[i]=map[r+i][c];
                        }
                        int hash=makeHash(l,array);
                        hashs[hash].add(new Node(r,c,true));
                    }
                }
            }
        }
    }

    int numberOfCandidate(int M, int mStructure[]) {
        if(M==1) {
            return N*N;
        }
        int hash=makeHash(M,mStructure);
        int reverseHash=makeReverseHash(M,mStructure);

        if(hash==reverseHash) {
            return hashs[getHash(hash)].size();
        }
        return hashs[getHash(hash)].size()+hashs[getHash(reverseHash)].size();
    }

    int maxArea(int M, int mStructure[], int mSeaLevel) {
        if(M==1) {
            int result=0;
            for(int r=1;r<=N;++r) {
                for(int c=1;c<=N;++c) {
                    map[r][c]+=mStructure[0];
                    result=Math.max(result, bfs(mSeaLevel));
                    map[r][c]-=mStructure[0];
                }
            }
            return result;
        }
        int hash=makeHash(M,mStructure);
        int reverseHash=makeReverseHash(M,mStructure);
        int maxArea=0;
        if(hashs[getHash(hash)].size()+hashs[getHash(reverseHash)].size()==0) {
            return -1;
        }
        for(Node node:hashs[getHash(hash)]) {
            if(node.isHeight) { // 세로
                for(int i=0;i<M;++i) {
                    map[node.x+i][node.y]+=mStructure[i];
                }
                maxArea=Math.max(maxArea, bfs(mSeaLevel));
                for(int i=0;i<M;++i) {
                    map[node.x+i][node.y]-=mStructure[i];
                }
            }
            else { // 가로
                for(int i=0;i<M;++i) {
                    map[node.x][node.y+i]+=mStructure[i];
                }
                maxArea=Math.max(maxArea, bfs(mSeaLevel));
                for(int i=0;i<M;++i) {
                    map[node.x][node.y+i]-=mStructure[i];
                }
            }
        }
        if(hash==reverseHash) {
            return maxArea;
        }

        for(Node node:hashs[getHash(reverseHash)]) {
            if(node.isHeight) { // 세로
                for(int i=0;i<M;++i) {
                    map[node.x+i][node.y]+=mStructure[M-i-1];
                }
                maxArea=Math.max(maxArea, bfs(mSeaLevel));
                for(int i=0;i<M;++i) {
                    map[node.x+i][node.y]-=mStructure[M-i-1];
                }
            }
            else { // 가로
                for(int i=0;i<M;++i) {
                    map[node.x][node.y+i]+=mStructure[M-i-1];
                }
                maxArea=Math.max(maxArea, bfs(mSeaLevel));
                for(int i=0;i<M;++i) {
                    map[node.x][node.y+i]-=mStructure[M-i-1];
                }
            }
        }
        return maxArea;
    }

    int bfs(int mSeaLevel) {
        isVisited=new boolean[23][23];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        isVisited[0][0]=true;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        while(!q.isEmpty()) {
            int now[] = q.poll();
            for(int d=0;d<4;++d) {
                int mx=now[0]+dx[d];
                int my=now[1]+dy[d];
                if(mx<0||mx>N+1||my<0||my>N+1) continue;
                if(!isVisited[mx][my] && map[mx][my]<mSeaLevel) {
                    isVisited[mx][my]=true;
                    q.offer(new int[] {mx,my});
                }
            }
        }
        int result=0;
        for(int r=1;r<=N;++r) {
            for(int c=1;c<=N;++c) {
                if(!isVisited[r][c]) ++result;
            }
        }
        return result;
    }

    int makeHash(int length, int array[]) {
        int hash=0;
        for(int i=0;i<length-1;++i) {
            hash+=(int)Math.pow(10,length-i-2)*(array[i+1]-array[i]+5);
        }
        return hash;
    }

    int makeReverseHash(int length, int array[]) {
        int reverseArray[] = new int[length];
        for(int i=0;i<length;++i) {
            reverseArray[i]=array[length-i-1];
        }
        return makeHash(length,reverseArray);
    }

    int getHash(int originHash) {
        int hash=0;
        int length=(int)Math.log10(originHash)+1;
        for(int i=0;i<length;++i) {
            hash+=(10-(originHash/(int)Math.pow(10,length-i-1)))*(int)Math.pow(10, length-i-1);
            originHash%=(int)Math.pow(10, length-i-1);
        }
        return hash;
    }
}

