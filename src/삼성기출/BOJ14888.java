// https://www.acmicpc.net/problem/14888
// 연산자 끼워넣기, Silver1
// 2023년 10월 17일
// 미제출

package 삼성기출;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {

    static int N;
    static int A[];
    static int operator[];
    static boolean visited[];
    static int selectOperator[];

    static int maxVal=Integer.MIN_VALUE;
    static int minVal=Integer.MAX_VALUE;

    static void cal(){
        int result=A[0];


        for(int i=0;i<N-1;++i){
            if(selectOperator[i]==0){
                result+=A[i+1];
            }
            else if(selectOperator[i]==1){
                result-=A[i+1];
            }
            else if(selectOperator[i]==2){
                result*=A[i+1];
            }
            else if(selectOperator[i]==3){
                result/=A[i+1];
            }
        }

        maxVal = Math.max(maxVal,result);
        minVal = Math.min(minVal,result);
    }

    static void dfs(int depth){
        if(depth==N-1){
            cal();
            return;
        }

        for(int i=0;i<N-1;++i){
            if(!visited[i]){
                visited[i]=true;
                selectOperator[depth]=operator[i];
                dfs(depth+1);
                visited[i]=false;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        visited = new boolean[N-1];
        operator = new int[N-1];
        selectOperator = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int index=0;
        for(int i=0;i<4;++i){
            int val=Integer.parseInt(st.nextToken());

            for(int j=0;j<val;++j) {
                operator[index++] = i;
            }
        }

        dfs(0);

        bw.write(maxVal+"\n");
        bw.write(minVal+"\n");
        bw.flush();
        bw.close();
    }
}
