package SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2357 {

    static int max_tree[];
    static int min_tree[];
    static int max_init(int arr[], int node, int nodeLeft, int nodeRight){
        if(nodeLeft==nodeRight){
            return max_tree[node]=arr[nodeLeft];
        }

        int mid=nodeLeft+(nodeRight-nodeLeft)/2;
        return max_tree[node]=Math.max(max_init(arr,node*2,nodeLeft,mid),
                max_init(arr,node*2+1,mid+1,nodeRight));
    }

    static int min_init(int arr[], int node, int nodeLeft, int nodeRight){
        if(nodeLeft==nodeRight){
            return min_tree[node]=arr[nodeLeft];
        }

        int mid=nodeLeft+(nodeRight-nodeLeft)/2;
        return min_tree[node]=Math.min(min_init(arr,node*2,nodeLeft,mid),
                min_init(arr,node*2+1,mid+1,nodeRight));
    }

    static int max_query(int start, int end, int node, int nodeLeft, int nodeRight){
        if(start>nodeRight || end<nodeLeft){
            return -1;
        }

        if(start<=nodeLeft && end>=nodeRight){
            return max_tree[node];
        }

        int mid=nodeLeft+(nodeRight-nodeLeft)/2;
        return Math.max(max_query(start,end,node*2,nodeLeft,mid),
                max_query(start,end,node*2+1,mid+1,nodeRight));
    }

    static int min_query(int start, int end, int node, int nodeLeft, int nodeRight){
        if(start>nodeRight || end<nodeLeft){
            return 1000000001;
        }

        if(start<=nodeLeft && end>=nodeRight){
            return min_tree[node];
        }

        int mid=nodeLeft+(nodeRight-nodeLeft)/2;
        return Math.min(min_query(start,end,node*2,nodeLeft,mid),
                min_query(start,end,node*2+1,mid+1,nodeRight));
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for(int i=0;i<N;++i){
            arr[i]=Integer.parseInt(br.readLine());
        }
        max_tree=new int[4*N];
        min_tree=new int[4*N];
        min_init(arr,1,0,N-1);
        max_init(arr,1,0,N-1);

        for(int i=0;i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            System.out.println(min_query(a-1,b-1,1,0,N-1)+" "
                    +max_query(a-1,b-1,1,0,N-1));
        }
    }
}
