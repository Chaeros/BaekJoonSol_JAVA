// https://www.acmicpc.net/problem/9079
// 동전 게임, Silver2
// 2023년 7월 26일, 합격

package BitMask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem9079 {

    static class Node{
        int num;
        int count;

        public Node(int num,int count){
            this.num=num;
            this.count=count;
        }
    }

    static int bfs(int start){
        Queue<Node> q = new LinkedList<>();
        boolean visited[]=new boolean[512];
        visited[start]=true;

        Node node=new Node(start,0);

        q.offer(node);
        while(!q.isEmpty()){
            Node x = q.poll();

            if(x.num==0 || x.num==511){
                return x.count;
            }
            
            //행 뒤집기
            for(int i=0;i<3;i++){
                Node y=new Node(x.num,x.count);
                y.num^=(448>>(3*i));
                if(!visited[y.num]){
                    visited[y.num]=true;
                    Node temp = new Node(y.num,y.count+1);
                    q.offer(temp);
                }
            }

            //열 뒤집기
            for(int i=0;i<3;++i){
                Node y=new Node(x.num,x.count);
                y.num^=(292>>1*i);
                if(!visited[y.num]){
                    visited[y.num]=true;
                    Node temp = new Node(y.num,y.count+1);
                    q.offer(temp);
                }
            }

            //대각선(\) 256+16+1
            Node y=new Node(x.num,x.count);
            y.num^=273;
            if(!visited[y.num]){
                visited[y.num]=true;
                Node temp = new Node(y.num,y.count+1);
                q.offer(temp);
            }

            //대각선(/) 64+16+4
            y=new Node(x.num,x.count);
            y.num^=84;
            if(!visited[y.num]){
                visited[y.num]=true;
                Node temp = new Node(y.num,y.count+1);
                q.offer(temp);
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;
        int T = Integer.parseInt(scanner.nextLine());

        while(T!=0){
            int num=0;
            for(int i=0;i<3;++i){
                st=new StringTokenizer(scanner.nextLine());
                for(int j=0;j<3;++j){
                    int val=0;
                    num=num<<1;
                    if(st.nextToken().equals("H")){
                        val=1;
                        num+=1;
                    }
                }
            }
            System.out.println(bfs(num));
            --T;
        }
    }
}