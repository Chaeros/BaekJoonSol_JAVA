// https://www.acmicpc.net/problem/1062
// 가르침, Gold4
// 2023년 9월 8일
// 통과

package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1062{
    static int N,K;
    static String voca[];
    static int resultCount=0;
    static boolean visited[];

    static void dfs(int depth, int x){
        if(depth==K-5){
            int count=0;
            for(int i=0;i<N;++i){
                boolean pass=true;
                for(int j=0;j<voca[i].length();++j){
                    if(!visited[voca[i].charAt(j)-97]){
                        pass=false;
                        break;
                    }
                }
                if(pass) ++count;
            }
            resultCount=Math.max(resultCount,count);
        }
        else{
            for(int i=x;i<26;++i){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(depth+1,i);
                    visited[i]=false;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        voca = new String[N];
        visited = new boolean[26];

        visited['a'-97]=true;
        visited['n'-97]=true;
        visited['t'-97]=true;
        visited['i'-97]=true;
        visited['c'-97]=true;

        Arrays.fill(voca,"");

        for(int i=0;i<N;++i){
            String str = br.readLine();
            for(int j=4;j<str.length()-4;++j){
                voca[i]+=str.charAt(j);
            }
        }

        if(K==26){
            bw.write(N+"\n");
            bw.flush();
            bw.close();
            return;
        }
        else if(K<5){
            bw.write(0+"\n");
            bw.flush();
            bw.close();
            return;
        }

        dfs(0,0);
        bw.write(resultCount+"\n");
        bw.flush();
        bw.close();
    }
}