import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main{

    static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    static boolean notLeafNode[];
    static int score[];
    static void dfs(int x){
        int count=0;
        if(notLeafNode[x]){
            for(int a:graph.get(x)){
                dfs(a);
                count+=score[a];
            }
        }
        else{
            ++count;
        }
        score[x]=count;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total_sp=Integer.parseInt(br.readLine());
        int N=6;

        for(int i=0;i<N+1;++i){
            graph.add(new ArrayList<>());
        }

        notLeafNode=new boolean[N+1];
        boolean notRootNode[]=new boolean[N+1];
        score=new int[N+1];

        for(int i=0;i<N-1;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            notLeafNode[first]=true;
            notRootNode[second]=true;

            graph.get(first).add(second);
        }

        int rootNum=1;
        for(int i=1;i<N+1;++i){
            if(notRootNode[i]==false){
                rootNum=i;
                break;
            }
        }

        dfs(rootNum);
        System.out.println();
        int sum=0;
        for(int i=1;i<N+1;++i){
            sum+=score[i];
            System.out.println(score[i]);
        }

        System.out.println("\nsum="+sum);
        int d=total_sp/sum;
        for(int i=1;i<N+1;++i){
            System.out.println(score[i]*d);
        }
    }
}