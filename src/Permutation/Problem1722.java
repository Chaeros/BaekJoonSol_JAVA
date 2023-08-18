// https://www.acmicpc.net/problem/1722
// 순열의 순서, Gold5
// 2023년 8월 18일
// 통과

package Permutation;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1722{
    static int N,K;
    static boolean visited[];
    static long order=0;
    static int result[];
    static int objective[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long factorial(long x){
        long result=1;
        while(x>0){
            result*=x;
            --x;
        }
        return result;
    }

    static void sol() throws IOException {
        if(K==1){
            for(int i=1;i<=N;++i){
                for(int j=1;j<=N;++j){
                    if(visited[j]) continue;
                    if(order>factorial(N-i)){
                        order-=factorial(N-i);
                    }
                    else{
                        result[i]=j;
                        visited[j]=true;
                        break;
                    }
                }
            }
            for(int i=1;i<=N;++i){
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            bw.flush();
            bw.close();
        }
        else{
            long count=1;
            for(int i=1;i<=N;++i){
                for(int j=1;j<objective[i];++j){
                    if(visited[j]) continue;
                    count+=factorial(N-i);
                }
                visited[objective[i]]=true;
            }
            bw.write(count+"\n");
            bw.flush();
            bw.close();
        }
    }

    public static void main(String args[]) throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];

        if(K==1){
            order=Long.parseLong(st.nextToken());
        }
        else{
            objective = new int[N+1];
            for(int i=1;i<N+1;++i){
                objective[i]=Integer.parseInt(st.nextToken());
            }
        }
        sol();
    }
}